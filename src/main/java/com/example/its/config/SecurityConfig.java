package com.example.its.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@EnableWebSecurity  // 웹 세큐리티 관련 설정이 있음을 명시
public class SecurityConfig {

    // private CustomUserDetailService userDetailsService;
    // private PasswordEncoder passwordEncoder;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
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
            // users이하 리소스는 ADMIN권한이 필요
            .mvcMatchers("/users/**").hasAnyAuthority("ADMIN")
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
        
        return http.build();
    }


    // 5.7이후 불필요하게 되었다
    //  - PasswordEncoderConfig가 자동으로 등록 됨
    //  - UserDetailsService가 자동으로 등록 됨
    //
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth
    //         .userDetailsService(userDetailsService)
    //         //passowrd encoder : 패스워드를 해쉬화 하기 위함
    //         .passwordEncoder(passwordEncoder)
    //         // .passwordEncoder(NoOpPasswordEncoder.getInstance())
    //         ;
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }
}
