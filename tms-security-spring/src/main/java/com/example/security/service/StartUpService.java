package com.example.security.service;

import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class StartUpService {

    private final UserRepository repository;

    @PostConstruct
    public void init() {
        User read = User.builder()
                .id(UUID.randomUUID())
                .username("read")
                .password("pass")
                .auth("read")
                .build();

        User write = User.builder()
                .id(UUID.randomUUID())
                .username("write")
                .password("pass")
                .auth("write")
                .build();

        User user = User.builder()
                .id(UUID.randomUUID())
                .username("user")
                .password("pass")
                .auth("ROLE_USER")
                .build();

        User admin = User.builder()
                .id(UUID.randomUUID())
                .username("admin")
                .password("pass")
                .auth("ROLE_ADMIN")
                .build();

        repository.save(read);
        repository.save(write);
        repository.save(user);
        repository.save(admin);
    }

}
