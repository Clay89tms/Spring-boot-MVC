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
        User user = User.builder()
                .id(UUID.randomUUID())
                .username("user1")
                .password("pass")
                .auth("read")
                .build();

        User admin = User.builder()
                .id(UUID.randomUUID())
                .username("admin1")
                .password("admin")
                .auth("write")
                .build();

        repository.save(user);
        repository.save(admin);
    }

}
