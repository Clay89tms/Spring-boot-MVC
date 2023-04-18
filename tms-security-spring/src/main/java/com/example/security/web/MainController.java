package com.example.security.web;

import com.example.security.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor

@Controller
@RequestMapping("/")
public class MainController {

    private final TestService testService;

    @GetMapping("/mainpage")
    public String main(){
        return "main-page.html";
    }

    @GetMapping("/loginpage")
    public String login(){
        return "login-page.html";
    }

    @GetMapping("/infopage")
    public String info(){
        return "info-page.html";
    }

    @GetMapping("/pageread")
    public String pageread(){
        return "page-read.html";
    }

    @GetMapping("/pagewrite")
    public String pagewrite(){
        return "page-write.html";
    }

    @GetMapping("/pageuser")
    public String pageuser(){
        return "page-user.html";
    }

    @GetMapping("/pageadmin")
    public String pageadmin(){
        return "page-admin.html";
    }

    @GetMapping("/test")
//    @Secured({"ROLE_USER"})
    public String test(){
        testService.test();
        return "";
    }
}
