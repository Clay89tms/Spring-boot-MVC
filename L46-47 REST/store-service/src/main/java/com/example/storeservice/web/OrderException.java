package com.example.storeservice.web;

import lombok.Data;

@Data
public class OrderException extends RuntimeException {

    private String errorMessage;

    public OrderException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
