package com.example.its.domain.auth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return userRepository.findByUserName(username).map((user) -> {
                // 유저 발견시
                return new CustomUserDetails(user.getUsername(), user.getPassword(), Collections.emptyList());
            }).orElseThrow(() -> {
                // Optional 내용물이 null일 경우
                return new UsernameNotFoundException(username);
            });
        }
}
