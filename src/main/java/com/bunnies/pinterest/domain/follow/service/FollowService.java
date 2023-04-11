package com.bunnies.pinterest.domain.follow.service;

import com.bunnies.pinterest.domain.follow.entity.Follow;
import com.bunnies.pinterest.domain.follow.repository.FollowRepository;
import com.bunnies.pinterest.domain.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FollowService {
    final private FollowRepository followRepository;

    //read
    public List<Follow> getFollowers(String memberEmailId) {
        return followRepository.findAllByToMemberEmailId(memberEmailId);
    }
    public List<Follow> getFollowings(String memberEmailId) {
        return followRepository.findAllByFromMemberEmailId(memberEmailId);
    }

    //write
    public Follow create(MemberDto fromMember, MemberDto toMember) {
        if (fromMember.emailId().equals(toMember.emailId())) {
            throw new IllegalArgumentException("From, To 회원이 동일합니다");
        }
        var follow = Follow
                .builder()
                .fromMemberEmailId(fromMember.emailId())
                .toMemberEmailId(toMember.emailId())
                .build();

        return followRepository.save(follow);
    }
}
