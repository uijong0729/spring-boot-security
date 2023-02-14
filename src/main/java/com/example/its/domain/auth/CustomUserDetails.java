package com.example.its.domain.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/*
 * 스프링 시큐리티가 제공하는 UserDetails 인터페이스를 구현한 클래스
 */
public class CustomUserDetails extends User {
    
    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> auth) {
        super(username, password, auth);
    }
}
