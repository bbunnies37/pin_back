package com.bunnies.pinterest.application.usecase;


import com.bunnies.pinterest.domain.follow.service.FollowService;
import com.bunnies.pinterest.domain.member.dto.MemberProfileDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMemberProfileUsecase {
    final private MemberService memberService;
    final private FollowService followService;

    public MemberProfileDto memberProfileDto(Member member){
        var followerCnt = followService.getFollowers(member.getEmail()).size();
        var followingCnt = followService.getFollowings(member.getEmail()).size();

        return new MemberProfileDto(member.getEmail() , member.getName(), followerCnt , followingCnt);
    }

}
