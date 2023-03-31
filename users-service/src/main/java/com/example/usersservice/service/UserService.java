package com.example.usersservice.service;

import com.example.usersservice.model.UserEntity;
import com.example.usersservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserService {

    private final UserRepository repository;

    public UserEntity getByLogin(String login) {
        return null;
    }
}
