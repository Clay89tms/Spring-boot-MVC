package com.example.carservice.service;

import com.example.carservice.config.MapperConfig;
import com.example.carservice.model.CarDto;
import com.example.carservice.model.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(config = MapperConfig.class)
public interface CarMapper {

    CarDto updateCarFromDto(CarEntity car);
//    CarDto updateCarFromDto(CarEntity carEntity, @MappingTarget CarDto carDto);
}
