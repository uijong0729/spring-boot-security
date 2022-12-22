package com.example.its.web.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.its.domain.user.UserService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        
        // templates 기준으로 상대경로
        return "users/list";
    }
}
