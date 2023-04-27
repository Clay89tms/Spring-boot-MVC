package com.example.security.web;

import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import com.example.security.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RequiredArgsConstructor

@Controller
@RequestMapping("/")
public class MainController {

    private final TestService testService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/mainpage")
    public String main() {
        return "main-page.html";
    }

    @GetMapping("/loginpage")
    public String login() {
        return "login-page.html";
    }

    @GetMapping("/infopage")
    public String info() {
        return "info-page.html";
    }

    @GetMapping("/pageread")
    public String pageread() {
        return "page-read.html";
    }

    @GetMapping("/pagewrite")
    public String pagewrite() {
        return "page-write.html";
    }

    @GetMapping("/pageuser")
    public String pageuser() {
        return "page-user.html";
    }

    @GetMapping("/pageadmin")
    public String pageadmin() {
        return "page-admin.html";
    }

    @GetMapping("/test")
//    @Secured({"ROLE_USER"})
    public String test() {
        testService.test();
        return "";
    }

    @PostMapping("/create")
    public String create(@RequestParam(name = "username") String username,
                         @RequestParam(name = "password") String password){
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setAuth("ROLE_USER");
        userRepository.save(user);
        return "login-page.html";
    }
}
