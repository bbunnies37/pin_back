package com.bunnies.pinterest.domain.member.config.jwt;
public interface JwtProperties {
    String SECRET = "sdjfalkjdcdsmsdijpkf123212312313lsdkfsdklfkd";
    int EXPIRATION_TIME = 864000000; // 10일 (1/1000초)
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
}