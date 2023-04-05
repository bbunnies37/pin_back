package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.application.usecase.CreateFollowMemberUsecase;
import com.bunnies.pinterest.application.usecase.GetFollowInfoMembersUsecase;
import com.bunnies.pinterest.domain.follow.dto.FollowDto;
import com.bunnies.pinterest.domain.member.dto.MemberDto;
import com.bunnies.pinterest.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
public class FollowController {
    final private CreateFollowMemberUsecase createFollowMemberUsecase;
    final private GetFollowInfoMembersUsecase getFollowInfoMembersUsecase;

    @PostMapping("/follow")
    public List<MemberDto> register(@RequestBody FollowDto followDto) {
        createFollowMemberUsecase.execute(followDto);
        return getFollowInfoMembersUsecase.executeFollower(followDto.fromMemberEmailId());
    }

    @GetMapping("/follower/{emailId}")
    public List<MemberDto> getFollowers(@PathVariable String emailId) {
       // log.info("email222 : {}",member.getEmail());
        return getFollowInfoMembersUsecase.executeFollower(emailId);
    }

    @GetMapping("/following/{emailId}")
    public List<MemberDto> getFollowings(@PathVariable String emailId) {
        return getFollowInfoMembersUsecase.executeFollowing(emailId);
    }
}