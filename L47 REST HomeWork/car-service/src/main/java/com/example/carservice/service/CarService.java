package com.example.carservice.service;

import com.example.carservice.model.CarEntity;
import com.example.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class CarService {

    private final CarRepository repository;

    public CarEntity createCarInBD(CarEntity car) {
        return repository.save(car);
    }

    public CarEntity getCarInDB(UUID id) {
        //add my error class
        return repository.findById(id).orElseThrow(() -> new RuntimeException("dont find a car"));
    }

    public List<CarEntity> getAllCarInBD() {
        return repository.findAll();
    }

    public CarEntity updateCarInBD(CarEntity car) {
        //add my error class/ del null
        if(repository.existsById(car.getId())) {
            CarEntity carInBD = repository.findById(car.getId()).get();
            if (!car.getModel().equals(null)){
                carInBD.setModel(car.getModel());
            }
            if (car.getColor() != null || !car.getColor().isBlank()){
                carInBD.setColor(car.getColor());
            }
            if (car.getPrice() != null){
                carInBD.setPrice(car.getPrice());
            }
            return repository.save(carInBD);
        }
        return null;
    }


    public void deleteCarById(UUID id) {
        var carByIdFromBD = repository.findById(id);
        repository.deleteById(id);
    }

    public CarEntity getCarByModel(String model) {
        return repository.findByModel(model);
    }
}