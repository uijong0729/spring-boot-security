package com.example.its.domain.auth;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 메소드별로 권한 체크를 부여할 수 있다.
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    public void create(String username, String password) {
        // 인코드
        var encodedPassword = passwordEncoder.encode(password);
        // 암호화 된 패스워드를 저장
        userRepository.insert(username, encodedPassword);
    }
}
