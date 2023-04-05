package com.example.usersservice.exp;


import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{

    private String error;

    public UserNotFoundException(String error) {
        this.error = error;
    }
}
