package com.bunnies.pinterest.domain.member.dto;

public record MemberMyPageDto(String picture ,
                              String emailId,
                              String firstName ,
                              String lastName,
                              int follower,
                              int following){
}
