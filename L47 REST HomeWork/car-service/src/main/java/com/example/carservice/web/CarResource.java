package com.example.carservice.web;

import com.example.carservice.exp.ErrorResponse;
import com.example.carservice.model.CarDto;
import com.example.carservice.model.CarEntity;
import com.example.carservice.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/car")
@Tag(name = "Car building")
public class CarResource {

    private final CarService service;

    @PostMapping
    @Operation(summary = "build car", description = "put field for building a Car")
    @ApiResponses(value = {
            @ApiResponse(description = "return building car", responseCode = "201",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema build",
                            implementation = CarEntity.class)))
    })
    public CarDto saveCar(@RequestBody CarEntity car) {
        return service.createCar(car);
    }

    @GetMapping
    @Operation(summary = "find car", description = "write ID car and she find you're car")
    @ApiResponses(value = {
            @ApiResponse(description = "fail to find car", responseCode = "404",
                    content = @Content(schema = @Schema(implementation = ClassNotFoundException.class))),
            @ApiResponse(description = "return find car", responseCode = "200",
                    content = @Content(mediaType = "application/JSON1", schema = @Schema(name = "Schema find by ID",
                            implementation = CarEntity.class)))
    })
    public CarDto getCarById(@RequestParam(name = "id") UUID id) {

        return service.getCarById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "find all car", description = "request list building cars")
    @ApiResponses(value = {
            @ApiResponse(description = "return all building cars", responseCode = "200",
                    content = @Content(mediaType = "application/JSON",
                            array = @ArraySchema(schema = @Schema(name = "Schema find all cars",
                                    implementation = CarEntity.class))))
    })
    public List<CarDto> getAllCar() {
        return service.getAllCar();
    }

    @PutMapping
    @Operation(summary = "update car", description = "write ID car and fields for update")
    @ApiResponses(value = {
            @ApiResponse(description = "fail to find car", responseCode = "404",
                    content = @Content(schema = @Schema(implementation = ClassNotFoundException.class))),
            @ApiResponse(description = "return updating car", responseCode = "201",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema update car",
                            implementation = CarEntity.class)))
    })
    public CarDto update(@RequestBody CarDto car) {
        return service.updateCar(car);
    }

    @DeleteMapping
    @Operation(summary = "delete car", description = "write ID car for DELETE")
    @ApiResponses(value = {
            @ApiResponse(description = "fail to find car", responseCode = "404",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "DELETE car", responseCode = "200",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema delete car")))
    })
    public void delete(@RequestBody CarEntity car) {
        service.deleteCarById(car.getId());
    }

}
