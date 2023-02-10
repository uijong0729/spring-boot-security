package com.example.its.domain.auth;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void create(String username, String password) {
        // 인코드
        var encodedPassword = passwordEncoder.encode(password);
        // 암호화 된 패스워드를 저장
        userRepository.insert(username, encodedPassword);
    }
}
