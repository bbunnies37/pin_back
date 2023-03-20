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
    public List<Follow> getFollowers(String memberEmail) {
        return followRepository.findAllByToMemberEmail(memberEmail);
    }
    public List<Follow> getFollowings(String memberEmail) {
        return followRepository.findAllByFromMemberEmail(memberEmail);
    }

    //write
    public Follow create(MemberDto fromMember, MemberDto toMember) {
        if (fromMember.email().equals(toMember.email())) {
            throw new IllegalArgumentException("From, To 회원이 동일합니다");
        }
        var follow = Follow
                .builder()
                .fromMemberEmail(fromMember.email())
                .toMemberEmail(toMember.email())
                .build();

        return followRepository.save(follow);
    }
}
