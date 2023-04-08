package com.example.carservice.service;

import com.example.carservice.exp.CarNotFoundException;
import com.example.carservice.exp.FieldNotFoundException;
import com.example.carservice.model.CarEntity;
import com.example.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class CarService {

    private final CarRepository repository;

    public CarEntity createCarInBD(CarEntity car) {
//        if (car.getModel() == null || car.getColor() == null || car.getPrice() == null) {
//            String dontField = "Next fields are not field:";
//            if (car.getModel() == null) {
//                dontField += "\nmodel: missing value";
//            }
//            if (car.getColor() == null) {
//                dontField += "\ncolor: missing value";
//            }
//            if (car.getPrice() == null) {
//                dontField += "\nprice: missing value";
//            }
//            throw new FieldNotFoundException(dontField);
//
//        }
        return repository.save(car);
    }

    public CarEntity getCarInDB(UUID id) {
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + id + "}"));
    }

    public List<CarEntity> getAllCarInBD() {
        return repository.findAll();
    }

    public CarEntity updateCarInBD(CarEntity car) {
        //add my error class/ del null
        if (repository.existsById(car.getId())) {
            CarEntity carInBD = repository.findById(car.getId()).get();
            if (car.getModel() != null) {
                carInBD.setModel(car.getModel());
            }
            if (car.getColor() != null && !car.getColor().isBlank()) {
                carInBD.setColor(car.getColor());
            }
            if (car.getPrice() != null) {
                carInBD.setPrice(car.getPrice());
            }
            return repository.save(carInBD);
        }
        return null;
    }


    public void deleteCarById(UUID id) {
        repository.findById(id).orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + id + "}"));
        var carByIdFromBD = repository.findById(id);
        repository.deleteById(id);

    }

    public CarEntity getCarByModel(String model) {
        return repository.findByModel(model);
    }
}