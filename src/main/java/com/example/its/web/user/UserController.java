package com.example.its.web.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    // Validated 유효성 체크
    // @Validated 인수 바로 뒤에 바로 BindingResult를 인수로 추가하는 것이 중요
    @PostMapping
    public String create(@Validated UserForm form, BindingResult bindingResult) {
        log.info("create : " + form.getUsername());
        // Validated 에러가 발생한다면
        if (bindingResult.hasErrors()) {
            return showCreateForm(form);
        }
        return "redirect:/users";
    }

    
}
