package com.example.storeservice.web;

import lombok.Data;

@Data
public class OrderExeption extends RuntimeException {

    private String errorMessage;

    public OrderExeption(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
