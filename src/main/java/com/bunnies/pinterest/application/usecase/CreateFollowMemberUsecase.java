package com.bunnies.pinterest.application.usecase;

import com.bunnies.pinterest.domain.follow.dto.FollowDto;
import com.bunnies.pinterest.domain.follow.service.FollowService;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateFollowMemberUsecase {
    final private MemberService memberService;
    final private FollowService followService;

    public void execute(FollowDto followDto) {
        var fromMember = memberService.getMember(followDto.fromMemberEmail());
        var toMember = memberService.getMember(followDto.toMemberEmail());
        followService.create(fromMember, toMember);
    }
}