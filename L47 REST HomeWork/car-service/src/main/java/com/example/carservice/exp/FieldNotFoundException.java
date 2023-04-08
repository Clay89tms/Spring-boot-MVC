package com.example.carservice.exp;

import lombok.Data;

@Data
public class FieldNotFoundException extends RuntimeException{

    private String fieldError;

    public FieldNotFoundException(String fieldError) {
        this.fieldError = fieldError;
    }
}
