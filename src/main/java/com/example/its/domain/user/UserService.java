package com.example.its.domain.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.its.domain.auth.User;
import com.example.its.domain.auth.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
