package com.bunnies.pinterest.domain.member.service;

import com.bunnies.pinterest.domain.member.config.jwt.JwtTokenProvider;
import com.bunnies.pinterest.domain.member.dto.MemberDto;
import com.bunnies.pinterest.domain.member.dto.MemberJoinRequestDto;
import com.bunnies.pinterest.domain.member.dto.MemberLoginDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import com.bunnies.pinterest.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public String join(MemberJoinRequestDto requestDto) {
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        memberRepository.save(requestDto.toEntity());
        return requestDto.getEmail();
    }

    public String login(MemberLoginDto requestDto) {
        var member = memberRepository.findByEmail(requestDto.email())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 email 입니다."));
        if( !passwordEncoder.matches(requestDto.password(), member.getPassword()) ) {
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }
        return jwtTokenProvider.generateToken(member.getEmail() , "USER");
    }

    public List<MemberDto> getMembers(List<String> memberEmails) {
        var members = memberRepository.findAllByEmailIn(memberEmails);
        return members.stream()
                .map(this::toDto)
                .toList();
    }
    public MemberDto getMember(String memberEmail) {
        var member = memberRepository.findByEmail(memberEmail).orElseThrow();
        return toDto(member);
    }
    public MemberDto toDto(Member member) {
        return new MemberDto(member.getEmail(), member.getName(), member.getAge());
    }
}
