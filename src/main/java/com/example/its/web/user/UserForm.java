package com.example.its.web.user;

import javax.validation.constraints.NotBlank;

import com.example.its.web.validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {
    
    // validation
    @NotBlank
    @UniqueUsername
    private String username;
    
    // validation
    @NotBlank
    private String password;
}