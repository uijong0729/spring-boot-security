package com.example.its.web.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(min = 12, max = 128)
    private String password;
    
    // validation
    @NotBlank
    private String authority;
}