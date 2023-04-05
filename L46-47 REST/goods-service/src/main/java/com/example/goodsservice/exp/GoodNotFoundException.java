package com.example.goodsservice.exp;

import lombok.Data;

@Data
public class GoodNotFoundException extends RuntimeException{

    private String error;

    public GoodNotFoundException(String error) {
        this.error = error;
    }
}
