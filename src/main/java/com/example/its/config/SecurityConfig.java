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
            // login페이지는 인증 불필요 (permitAll)
            .mvcMatchers("/login/**").permitAll()  
            // 상기 이외의 리퀘스트는 인증이 필요 (authenticated)
            .anyRequest().authenticated()                
            .and()
            // 폼 로그인을 로그인 방식으로서 지정
            .formLogin()                                        
            // 로그인 페이지
            .loginPage("/login");                      
        
    }
}
