package com.example.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/mainpage")
    public String main(){
        return "main-page.html";
    }

    @GetMapping("/loginpage")
    public String login(){
        return "login-page.html";
    }
}
