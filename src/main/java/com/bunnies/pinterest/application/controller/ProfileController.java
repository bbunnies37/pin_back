package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.application.usecase.GetMemberProfileUsecase;
import com.bunnies.pinterest.domain.member.dto.MemberMyPageDto;
import com.bunnies.pinterest.domain.member.dto.MemberPublicProfileDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class ProfileController {

    final private GetMemberProfileUsecase getUserProfileUsecase;
    final private MemberService memberService;

    // 마이페이지
    @GetMapping("/{emailId}")
    public MemberMyPageDto getMemberProfile(@PathVariable String emailId) {
        return getUserProfileUsecase.memberProfileDto(emailId);
    }

    //프로필 수정페이지 정보 가져오기
    /*
    @GetMapping("/settings")
    public MemberPublicProfileDto getMemberPublicProfile(@AuthenticationPrincipal Member member) {

    }
    */

    //프로필 수정 - 사진 , 소개 , 사용자이름
    @PutMapping("/settings")
    public String updatePublicProfile(@RequestBody MemberPublicProfileDto requestDto) {
        return memberService.update(requestDto);
    }
}
