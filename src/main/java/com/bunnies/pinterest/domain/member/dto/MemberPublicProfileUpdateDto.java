package com.bunnies.pinterest.domain.member.dto;

public record MemberPublicProfileUpdateDto(String name,
                                           String lastName,
                                           String introduction,
                                           String website){
}
