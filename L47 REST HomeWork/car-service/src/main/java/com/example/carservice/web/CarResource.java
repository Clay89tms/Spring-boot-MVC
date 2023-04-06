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
    public void saveCar(@RequestBody CarEntity car){
        service.createCarInBD(car);
    }

    @GetMapping
    public CarEntity getCarById(@RequestParam(name = "id") UUID id){
        return service.getCarInDB(id);
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
    public void delete(@RequestParam(name = "id") UUID id){
        service.deleteCarById(id);
    }
}
