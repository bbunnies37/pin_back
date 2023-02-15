package com.bunnies.pinterest.domain.member.service;

import com.bunnies.pinterest.domain.member.dto.MemberJoinRequestDto;
import com.bunnies.pinterest.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public String join(MemberJoinRequestDto requestDto) {
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        memberRepository.save(requestDto.toEntity());
        return requestDto.getEmail();
    }

}
