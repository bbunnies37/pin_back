package com.bunnies.pinterest.application.usecase;

import com.bunnies.pinterest.domain.follow.entity.Follow;
import com.bunnies.pinterest.domain.follow.service.FollowService;
import com.bunnies.pinterest.domain.member.dto.MemberDto;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetFollowInfoMembersUsecase {
    final private MemberService memberService;
    final private FollowService followService;


    public List<MemberDto> executeFollower(String memberEmailId) {
        var follows = followService.getFollowers(memberEmailId);
        var memberEmailIds = follows
                .stream()
                .map(Follow::getFromMemberEmailId)
                .collect(Collectors.toList());
        return memberService.getMembers(memberEmailIds);
    }

    public List<MemberDto> executeFollowing(String memberEmailId) {
        var follows = followService.getFollowings(memberEmailId);
        var memberEmailIds = follows
                .stream()
                .map(Follow::getToMemberEmailId)
                .collect(Collectors.toList());
        return memberService.getMembers(memberEmailIds);
    }
}