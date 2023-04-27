package com.example.carservice.service;

import com.example.carservice.exp.CarNotFoundException;
import com.example.carservice.model.CarDto;
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
    private final CarMapper carMapper;

    public CarEntity createCar(CarEntity car) {
        return repository.save(car);
    }

    public CarEntity getCarById(UUID id) {
        CarEntity carEntity = repository.findById(id).get();
        return carEntity;
//        return repository.findById(id).orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + id + "}"));
    }

    public List<CarEntity> getAllCar() {
        return repository.findAll();
    }


    public CarEntity updateCar(CarDto car) {

        CarEntity carEntity = repository.findById(car.getId()).map(carUpdate -> carMapper.updateCarFromDto(car))
                .orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + car.getId() + "}"));
        return repository.save(carEntity);


//            CarDto carDto = carMapper.updateCarFromDto(carEntity);

//            CarEntity carFromDB = repository.findById(car.getId()).get();
//            if (car.getModel() != null) {
//                carFromDB.setModel(car.getModel());
//            }
//            if (car.getColor() != null && !car.getColor().isBlank()) {
//                carFromDB.setColor(car.getColor());
//            }
//            if (car.getPrice() != null) {
//                carFromDB.setPrice(car.getPrice());
//            }
//            return repository.save(carFromDB);

//            return carDto;
//        }
//        return null;
    }


    public void deleteCarById(UUID id) {
        repository.findById(id).orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + id + "}"));
        repository.deleteById(id);

    }


    public CarDto updateCarFromDto(CarEntity carEntity, CarDto carDto) {
        return carDto;
    }
}