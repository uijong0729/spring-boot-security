package com.example.its.web.user;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {
    
    // validation
    @NotBlank
    private String username;
    
    // validation
    @NotBlank
    private String password;
}