package com.example.carservice.exp;

import lombok.Data;

@Data
public class CarNotFoundException extends RuntimeException{

    private String error;

    public CarNotFoundException(String error) {
        this.error = error;
    }
}
