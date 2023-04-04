package com.bunnies.pinterest.domain.member.dto;

public record MemberMyPageDto(String picture ,
                              String userName,
                              String firstName ,
                              String lastName,
                              int follower,
                              int following){
}
