package com.example.storeservice.config;


import com.example.storeservice.dto.ErrorResponse;
import com.example.storeservice.web.OrderException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Optional;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            Integer status = Optional.ofNullable(response)
                    .map(Response::status)
                    .orElseThrow();
            if (status == 404) {
                ErrorResponse errorResponse;
                try {

                    ObjectMapper objectMapper = new ObjectMapper();
                    errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                throw new OrderException(errorResponse.getErrorResponseMessage());
            }
            throw new OrderException("UNEXPECTED error");
        };
    }

}
