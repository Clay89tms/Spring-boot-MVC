package com.example.storeservice.config;

import com.example.storeservice.web.OrderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class MyErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatus statusCode = response.getStatusCode();
        if (statusCode == HttpStatus.OK) {
            return false;
        }
        return true;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new OrderException("");
    }
}
