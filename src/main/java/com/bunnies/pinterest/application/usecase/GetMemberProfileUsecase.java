package com.bunnies.pinterest.application.usecase;


import com.bunnies.pinterest.domain.follow.service.FollowService;
import com.bunnies.pinterest.domain.member.dto.MemberMyPageDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import com.bunnies.pinterest.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetMemberProfileUsecase {
    final private MemberService memberService;
    final private FollowService followService;

    public MemberMyPageDto memberProfileDto(Member member){
        var followerCnt = followService.getFollowers(member.getEmail()).size();
        var followingCnt = followService.getFollowings(member.getEmail()).size();


        return new MemberMyPageDto(member.getPicture() ,
                                    member.getUsername(),
                                    member.getFirstName(),
                                    member.getLastName(),
                                    followerCnt ,
                                    followingCnt);
    }

}
