package com.example.repairservice.client;

import com.example.repairservice.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(
        name = "carClient",
        url = "http://127.0.0.1:8085/car"
)
public interface CarClient {
    @PostMapping
    CarDto saveCar(@RequestBody CarDto car);

    @GetMapping
    CarDto getCarById(@RequestParam(name = "id") UUID id);

    @GetMapping("/all")
    List<CarDto> getAllCar();

    @PutMapping
    CarDto update(@RequestBody CarDto car);

    @DeleteMapping
    void delete(@RequestParam(name = "id") UUID id);

}
