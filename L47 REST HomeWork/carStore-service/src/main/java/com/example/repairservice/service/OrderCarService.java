package com.example.repairservice.service;

import com.example.repairservice.client.CarClient;
import com.example.repairservice.dto.CarDto;
import com.example.repairservice.dto.OrderCarResponse;
import com.example.repairservice.dto.StoreCarRequest;
import com.example.repairservice.web.OrderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor

@Service
public class OrderCarService {

    private final CarClient carClient;

    public OrderCarResponse orderResponse(StoreCarRequest carRequest) {

        CarDto carById = carClient.getCarById(carRequest.getId());


        if (carById == null) {
            throw new OrderException("don't find car with ID {" + carById.getId() + "}");
        }
        return OrderCarResponse.builder()
                .idOrder(UUID.randomUUID())
                .model(carById.getModel())
                .color(carById.getColor())
                .price(carById.getPrice())
                .build();
    }
}
