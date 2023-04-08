package com.example.carservice.web;

import com.example.carservice.model.CarEntity;
import com.example.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/")
public class CarResource {

    private final CarService service;

    @PostMapping
    public CarEntity saveCar(@RequestBody CarEntity car){
        return service.createCarInBD(car);
    }

    @GetMapping
    public CarEntity getCarById(@RequestBody CarEntity car){

        return service.getCarInDB(car.getId());
    }

    @GetMapping("/all")
    public List<CarEntity> getAllCar(){
        return service.getAllCarInBD();
    }

    @PutMapping
    public CarEntity update(@RequestBody CarEntity car){
        return service.updateCarInBD(car);
    }

    @DeleteMapping
    public void delete(@RequestBody CarEntity car){
        service.deleteCarById(car.getId());
    }
}
