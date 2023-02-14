package com.example.its.domain.auth;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

import lombok.RequiredArgsConstructor;

/*
 * 데이터베이스로부터 임의의 유저정보를 받아 UserDetails형으로 변환하는 클래스
 * (개발자 임의의 유저 테이블 → 스프링 시큐리티 UserDetails)
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).map((user) -> {
            // 유저 발견시
            return new CustomUserDetails(user.getUsername(), user.getPassword(), toGrantedAuthorityList(user.getAuthority()));
        }).orElseThrow(() -> {
            // Optional 내용물이 null일 경우
            return new UsernameNotFoundException(username);
        });
    }

    /*
     * 한 유저가 복수의 권한을 갖고있는 패턴이 흔하므로 UserDetails의 권한에는 리스트형으로 건네준다
     */
    private List<GrantedAuthority> toGrantedAuthorityList(User.Authority auth) {
        return Collections.singletonList(new SimpleGrantedAuthority(auth.name()));
    }
}
