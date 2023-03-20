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


    public List<MemberDto> executeFollower(String memberEmail) {
        var follows = followService.getFollowers(memberEmail);
        var memberEmails = follows
                .stream()
                .map(Follow::getFromMemberEmail)
                .collect(Collectors.toList());
        return memberService.getMembers(memberEmails);
    }

    public List<MemberDto> executeFollowing(String memberEmail) {
        var follows = followService.getFollowings(memberEmail);
        var memberEmails = follows
                .stream()
                .map(Follow::getToMemberEmail)
                .collect(Collectors.toList());
        return memberService.getMembers(memberEmails);
    }
}