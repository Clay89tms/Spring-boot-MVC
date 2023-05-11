package com.example.carservice.service;

import com.example.carservice.exp.CarNotFoundException;
import com.example.carservice.model.CarDto;
import com.example.carservice.model.CarEntity;
import com.example.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RequiredArgsConstructor

@Service
public class CarService {

    private final CarRepository repository;
    private final CarMapper carMapper;

    public CarDto createCar(CarEntity car) {
        CarEntity carEntity = repository.save(car);
        return carMapper.convertCarToDto(carEntity);
    }

    public CarDto getCarById(UUID id) {
        CarEntity carEntity = repository.findById(id).orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + id + "}"));
        return carMapper.convertCarToDto(carEntity);
    }

    public List<CarDto> getAllCar() {
        List<CarEntity> carEntityList = repository.findAll();
        return carMapper.convertListCarToListEntity(carEntityList);
    }


    @Transactional
    public CarDto updateCar(CarDto car) {
        repository.findById(car.getId()).map(carNew -> car);
        CarEntity carEntity = repository.findById(car.getId())
                .orElseThrow(() -> new CarNotFoundException("don't find car with ID {" + car.getId() + "}"));
        carMapper.convertCarToDto(carEntity);
        carEntity = carMapper.convertCarToEntity(car);


        return car;


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


//    public CarDto updateCarFromDto(CarEntity carEntity, CarDto carDto) {
//        return carDto;
//    }
}