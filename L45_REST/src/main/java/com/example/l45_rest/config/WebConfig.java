package com.example.l45_rest.config;

import com.example.l45_rest.component.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class WebConfig {

    private final UserRepository repository;

    @PostMapping(value = "/person")
    public void save(){
        UserEntity user = new UserEntity();
        repository.save(user);
    }
}
