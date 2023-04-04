package com.example.storeservice.config;

import com.example.storeservice.web.OrderExeption;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Optional;

@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder(){
        return (methodKey, response) -> {
            Integer status = Optional.ofNullable(response)
                    .map(Response::status)
                    .orElseThrow();
            if(status == 404){
                byte[] bytes = new byte[0];
                try {
                    bytes = response.body().asInputStream().readAllBytes();
                    String s = new String(bytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            throw new OrderExeption();
        };
    }

}
