package com.example.usersservice.web;

import com.example.usersservice.model.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping("/{id}")
    public UserEntity get(@PathVariable (name = "id") String login){
        return null;
    }
}
