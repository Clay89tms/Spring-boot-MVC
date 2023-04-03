package com.example.storeservice.service;

import com.example.storeservice.dto.GoodDto;
import com.example.storeservice.dto.OrderResponse;
import com.example.storeservice.dto.StoreRequest;
import com.example.storeservice.dto.UserDto;
import com.example.storeservice.web.OrderExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RequiredArgsConstructor

@Service
public class OrderService {

    private final RestTemplate template;

    public OrderResponse makeOrder(StoreRequest dto) {
        var userUrl = "http://127.0.0.1:8081/users/" + dto.getLogin();
        UserDto user;
        try {
            user = template.getForObject(userUrl, UserDto.class);
        } catch (Exception exc) {
            throw new OrderExeption();
        }

        var goodUrl = "http://127.0.0.1:8082/goods/" + dto.getGoodName();
        GoodDto good;
        try {
            good = template.postForObject(goodUrl, null, GoodDto.class);
        } catch (Exception exc) {
            throw new OrderExeption();
        }
        return OrderResponse.builder()
                .orderId(UUID.randomUUID())
                .login(user.getLogin())
                .goodName(good.getName())
                .build();
    }
}
