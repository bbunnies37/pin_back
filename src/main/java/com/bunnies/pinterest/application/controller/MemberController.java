package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.domain.member.dto.MemberJoinRequestDto;
import com.bunnies.pinterest.domain.member.dto.MemberLoginDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestBody MemberJoinRequestDto requestDto) {
        log.info("email : {}",requestDto.getEmail());
        return memberService.join(requestDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody MemberLoginDto requestDto) {
        return memberService.login(requestDto);
    }

    //로그인 성공확인용 요청
    @GetMapping("/test")
    public String tokenTest(@AuthenticationPrincipal Member member) {
        log.info("email : {}",member.getEmail());
        return member.getEmail();
    }
}