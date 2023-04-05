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

    private String birthday;
    private List<String> category;

    public Member toEntity() {
        return Member.builder()
                .email(email)

                .emailId(emailId)
                .firstName(firstName)

                .password(password)
                .birthday(birthday)
                .category(category)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}
