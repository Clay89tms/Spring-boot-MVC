package com.example.carservice.web;

import com.example.carservice.exp.ErrorResponse;
import com.example.carservice.model.CarEntity;
import com.example.carservice.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
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
    public CarEntity saveCar(@RequestBody CarEntity car) {
        return service.createCarInBD(car);
    }

    @GetMapping
    @Operation(summary = "find car", description = "write ID car and she find you're car")
    @ApiResponses(value = {
            @ApiResponse(description = "fail to find car", responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(description = "return find car", responseCode = "200",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema find by ID",
                            implementation = CarEntity.class)))
    })
    public CarEntity getCarById(@RequestBody CarEntity car) {

        return service.getCarInDB(car.getId());
    }

    @GetMapping("/all")
    @Operation(summary = "find all car", description = "request list building cars")
    @ApiResponses(value = {
            @ApiResponse(description = "return all building cars", responseCode = "200",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema find all cars",
                            implementation = CarEntity.class)))
    })
    public List<CarEntity> getAllCar() {
        return service.getAllCarInBD();
    }

    @PutMapping
    @Operation(summary = "update car", description = "write ID car and fields for update")
    @ApiResponses(value = {
            @ApiResponse(description = "return updating car", responseCode = "201",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema update car",
                            implementation = CarEntity.class)))
    })
    public CarEntity update(@RequestBody CarEntity car) {
        return service.updateCarInBD(car);
    }

    @DeleteMapping
    @Operation(summary = "delete car", description = "write ID car for DELETE")
    @ApiResponses(value = {
            @ApiResponse(description = "DELETE car", responseCode = "200",
                    content = @Content(mediaType = "application/JSON", schema = @Schema(name = "Schema delete car",
                            implementation = CarEntity.class)))
    })
    public void delete(@RequestBody CarEntity car) {
        service.deleteCarById(car.getId());
    }
}
