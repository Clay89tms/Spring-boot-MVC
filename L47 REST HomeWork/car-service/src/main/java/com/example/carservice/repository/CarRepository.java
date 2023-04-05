package com.example.carservice.repository;

import com.example.carservice.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarEntity, UUID> {
    CarEntity findByModel(String model);

    //

}
