package com.example.repairservice.service;

import com.example.repairservice.client.CarClient;
import com.example.repairservice.dto.CarDto;
import com.example.repairservice.dto.OrderCarResponse;
import com.example.repairservice.dto.StoreCarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class OrderCarService {

    private final CarClient carClient;

    public OrderCarResponse orderResponse(StoreCarRequest dto) {
        String orderModel = dto.getModel();
        CarDto orderCar;
        List<CarDto> allCar = carClient.getAllCar();
        for (CarDto car : allCar) {
            if (car.getModel().equals(orderModel)) {
                orderCar = car;
                return OrderCarResponse.builder()
                        .idOrder(UUID.randomUUID())
                        .model(orderCar.getModel())
                        .color(orderCar.getColor())
                        .price(orderCar.getPrice())
                        .build();
            }
        }
        return null;

    }
}
