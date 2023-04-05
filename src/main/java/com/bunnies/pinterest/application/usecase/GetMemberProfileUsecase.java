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

    public MemberMyPageDto memberProfileDto(String emailId){
        var memberDto = memberService.getMember(emailId);
        var followerCnt = followService.getFollowers(memberDto.emailId()).size();
        var followingCnt = followService.getFollowings(memberDto.emailId()).size();

        return new MemberMyPageDto( memberDto.picture() ,
                                    memberDto.emailId(),
                                    memberDto.firstName(),
                                    memberDto.lastName(),
                                    followerCnt ,
                                    followingCnt);
    }

}
