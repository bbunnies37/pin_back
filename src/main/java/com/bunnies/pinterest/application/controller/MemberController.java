package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.domain.member.dto.MemberJoinRequestDto;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(@RequestBody MemberJoinRequestDto requestDto) {
        System.out.println(requestDto.getPassword() + " , " + requestDto.getEmail());
        return memberService.join(requestDto);
    }

}