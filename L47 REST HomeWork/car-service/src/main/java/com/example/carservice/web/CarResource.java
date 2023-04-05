package com.example.carservice.web;

import com.example.carservice.model.CarEntity;
import com.example.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/")
public class CarResource {

    private final CarService service;

    @PostMapping
    public void save(@RequestBody CarEntity car){
        service.createCar(car);
    }

    @GetMapping
    public CarEntity get(@RequestBody CarEntity car){
        return service.getCarInDB(car);
    }
}
