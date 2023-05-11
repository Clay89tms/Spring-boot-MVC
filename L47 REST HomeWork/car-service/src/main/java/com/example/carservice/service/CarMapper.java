package com.example.carservice.service;

import com.example.carservice.config.MapperConfigure;
import com.example.carservice.model.CarDto;
import com.example.carservice.model.CarEntity;
import org.mapstruct.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Mapper(config = MapperConfigure.class)
public interface CarMapper {

    CarDto convertCarToDto(CarEntity carEntity);

//    @Transactional
    CarEntity convertCarToEntity(CarDto carDto);

    List<CarDto> convertListCarToListEntity(List<CarEntity> list);
//    CarDto updateCarFromDto(CarEntity carEntity, @MappingTarget CarDto carDto);
}
