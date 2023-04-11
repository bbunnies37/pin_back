package com.bunnies.pinterest.domain.member.dto;

import com.bunnies.pinterest.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberPublicProfileDto {
    private String emailId;
    private String firstName;
    private String lastName;
    private String introduction;
    private String website;

    @Builder
    public MemberPublicProfileDto(String emailId, String firstName, String lastName, String password, String introduction, String website) {
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.introduction = introduction;
        this.website = website;
    }

}
