package com.example.usersservice.web;

import com.example.usersservice.exp.ErrorResponse;
import com.example.usersservice.exp.UserNotFoundException;
import com.example.usersservice.model.UserEntity;
import com.example.usersservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RequiredArgsConstructor

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService service;

    @GetMapping("/{id}")
    public UserEntity get(@PathVariable (name = "id") String login){
        return service.getByLogin(login);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> processError(UserNotFoundException exc){
        return ResponseEntity
                .status(404).
                body(new ErrorResponse(exc.getError()));
    }
}
