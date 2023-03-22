package com.example.l44_sbmvcthymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(){
        return "home.html";
    }

}
