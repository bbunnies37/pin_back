package com.bunnies.pinterest.domain.member.config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 -> 세션사용 X
                .and()
                .formLogin().disable()
                .httpBasic().disable()

                .authorizeRequests()
                .anyRequest().permitAll()
                //.antMatchers("join/**","/login/**","/index/**").permitAll()
                //.anyRequest().authenticated()
        ;

        return http.build();
    }

}