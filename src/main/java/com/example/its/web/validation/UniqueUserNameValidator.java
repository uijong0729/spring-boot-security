package com.example.its.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.its.domain.auth.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 존재하지 않으면 
        return userRepository.findByUserName(value).isEmpty();
    }
    
}
