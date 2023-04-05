package com.example.l44_sbmvcthymeleaf;

import com.example.l44_sbmvcthymeleaf.domain.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
