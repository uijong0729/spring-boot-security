package com.example.its.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity  // 웹 세큐리티 관련 설정이 있음을 명시
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .mvcMatchers("/login/**").permitAll()   // login페이지 인증 불필요
            .anyRequest().authenticated()                        // 상기 이외의 리퀘스트는 인증이 필요
            .and()
            .formLogin()                                        // 폼 로그인을 로그인 형식으로서 지정
            .loginPage("/login");                      // 로그인 페이지
        
    }
}
