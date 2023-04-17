package com.example.security.web;

import org.springframework.security.access.annotation.Secured;
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
    @Secured({"ROLE_USER"})
    public String test(){
        return "";
    }
}
