package com.example.its.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        // templates의 html확장자를 뺀 상대경로
        return "login";
    }
}
