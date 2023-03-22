package com.example.l44_sbmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@SpringBootApplication
public class L44SbmvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(L44SbmvcApplication.class, args);
    }

    @GetMapping
    public String goHome(){
        return "home.jsp";
    }

}
