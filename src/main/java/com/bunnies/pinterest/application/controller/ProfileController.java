package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.application.usecase.GetMemberProfileUsecase;
import com.bunnies.pinterest.domain.member.dto.MemberProfileDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/profile")
@RequiredArgsConstructor
@RestController
public class ProfileController {

    final private GetMemberProfileUsecase getUserProfileUsecase;

    @GetMapping("/")
    public MemberProfileDto getMemberProfile(@AuthenticationPrincipal Member member) {
        log.info("email : {}",member.getEmail());

        return getUserProfileUsecase.memberProfileDto(member);
    }

    //프로필 수정 - 사진 , 소개 , 사용자이름
}
