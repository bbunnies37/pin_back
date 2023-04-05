package com.bunnies.pinterest.domain.member.dto;

import com.bunnies.pinterest.domain.member.entity.Member;
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

    public Member toEntity() {
        return Member.builder()
                .emailId(emailId)
                .firstName(firstName)
                .lastName(lastName)
                .introduction(introduction)
                .website(website)
                .build();
    }

}
