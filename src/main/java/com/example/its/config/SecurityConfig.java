package com.example.its.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.its.domain.auth.CustomUserDetailService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableWebSecurity  // 웹 세큐리티 관련 설정이 있음을 명시
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomUserDetailService userDetailsService;
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 디버그용 h2-console 설정
        http
            .authorizeRequests()
            .antMatchers("/h2-conole/**").permitAll()
            .and()
            .csrf().ignoringAntMatchers("/h2-console/**")
            .and()
            .headers().frameOptions().disable();

        http
            .authorizeRequests()
            // login페이지는 인증 불필요 (permitAll)
            .mvcMatchers("/login/**").permitAll()  
            // 상기 이외의 리퀘스트는 인증이 필요 (authenticated)
            .anyRequest().authenticated()                
            .and()
            // 폼 로그인을 로그인 방식으로서 지정
            .formLogin()
            // 폼 로그인시 아이디의 파라미터 이름 지정
            .usernameParameter("username")
            // 폼 로그인시 아이디의 파라미터 이름 지정
            .passwordParameter("password")
            // 로그인 페이지
            .loginPage("/login");                      
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            //passowrd encoder : 패스워드를 해쉬화 하기 위함
            .passwordEncoder(passwordEncoder);
    }
}
