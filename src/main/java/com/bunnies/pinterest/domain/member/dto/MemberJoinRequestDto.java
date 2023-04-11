package com.bunnies.pinterest.domain.member.dto;

import com.bunnies.pinterest.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;
@Getter
@NoArgsConstructor
public class MemberJoinRequestDto{
    private String email;
    @Setter
    private String password;

    @Setter
    private String emailId;
    private String firstName;
    private String lastName;
    private String birthday;
    private List<String> category;

    private String introduction;
    private String website;
    public Member toEntity() {
        return Member.builder()
                .email(email)

                .emailId(emailId)
                .firstName(firstName)
                .lastName(null)
                .password(password)
                .birthday(birthday)
                .category(category)
                .roles(Collections.singletonList("ROLE_USER"))
                .introduction(null)
                .website(null)
                .build();
    }
}
