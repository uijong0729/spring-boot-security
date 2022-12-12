package com.example.its.domain.auth;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            // 로그인 성공
            if ("user".equals(username)) {
                return new CustomUserDetails(username, "password", Collections.emptyList());
            }
            
            // 로그인 실패
            throw new UsernameNotFoundException("user not found : [" + username + "]");
        }
}
