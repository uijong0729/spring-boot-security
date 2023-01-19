package com.example.its.web.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.its.domain.user.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    
    private final UserService userService;

    // Get /users
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        // templates 기준으로 상대경로
        return "users/list";
    }

    @GetMapping("/creationForm")
    public String showCreateForm(@ModelAttribute UserForm form) {
        log.info("showCreateForm : " + form.getUsername());
        return "users/creationForm";
    }

    // Post /users
    @PostMapping
    public String create(UserForm form) {
        log.info("create : " + form.getUsername());
        return "redirect:/users";
    }

    
}
