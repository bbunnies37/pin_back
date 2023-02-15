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
    private String name;
    private int age;
    private List<String> category;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .name(name)
                .password(password)
                .age(age)
                .category(category)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}
