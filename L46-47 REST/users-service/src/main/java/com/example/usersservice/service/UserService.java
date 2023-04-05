package com.example.usersservice.service;

import com.example.usersservice.exp.UserNotFoundException;
import com.example.usersservice.model.UserEntity;
import com.example.usersservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class UserService {

    private final UserRepository repository;

    @PostConstruct
    public void init(){
        UserEntity user1 = UserEntity.builder()
                .id(UUID.randomUUID())
                .login("Sergey")
                .build();

        UserEntity user2 = UserEntity.builder()
                .id(UUID.randomUUID())
                .login("Olya")
                .build();
        repository.save(user1);
        repository.save(user2);
    }

    public UserEntity getByLogin(String login) {
        return repository.findByLogin(login).
                orElseThrow(() -> new UserNotFoundException("User with login " + login + " not found"));
    }
}
