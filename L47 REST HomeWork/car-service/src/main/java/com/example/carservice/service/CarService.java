package com.example.carservice.service;

import com.example.carservice.model.CarEntity;
import com.example.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class CarService {

    private final CarRepository repository;

    public void createCar(CarEntity car) {
        repository.save(car);
    }

    public CarEntity getCarInDB(CarEntity car) {
        //+Errors
        return repository.findByModel(car.getModel());
    }
}