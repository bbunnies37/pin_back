package com.bunnies.pinterest.domain.member.service;

import com.bunnies.pinterest.domain.member.config.jwt.JwtTokenProvider;
import com.bunnies.pinterest.domain.member.dto.*;
import com.bunnies.pinterest.domain.member.entity.Member;
import com.bunnies.pinterest.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public String join(MemberJoinRequestDto requestDto) {
        var email = requestDto.getEmail();
        var emailId = email.substring(0,email.indexOf('@'));
        requestDto.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        requestDto.setEmailId(emailId);

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

    public List<MemberDto> getMembers(List<String> memberEmailIds) { // follow member
        var members = memberRepository.findAllByEmailIdIn(memberEmailIds);
        return members.stream()
                .map(this::toDto)
                .toList();
    }
    public MemberDto getMember(String emailId) { //profile
        var member = memberRepository.findByEmailId(emailId).orElseThrow();
        return toDto(member);
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(member.getPicture(),
                            member.getEmailId(),
                            member.getFirstName(),
                            member.getLastName(),
                            member.getIntroduction(),
                            member.getWebsite()
        );
    }

    @Transactional
    public String update(MemberPublicProfileDto requestDto) {
        String emailId = requestDto.getEmailId();
        Member member = memberRepository.findByEmailId(emailId)
                .orElseThrow(() ->
                        new IllegalArgumentException("해당 아이디가 존재하지 않습니다. emailId = " + emailId));
        member.update(requestDto.getEmailId(), requestDto.getFirstName(), requestDto.getLastName(), requestDto.getIntroduction(), requestDto.getWebsite());
        memberRepository.save(member);
        return member.getEmailId();
    }
}
