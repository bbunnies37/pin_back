package com.bunnies.pinterest.domain.member.dto;

public record MemberDto(String picture,
                        String emailId,
                        String firstName,
                        String lastName,
                        String introduction,
                        String website) {
}
