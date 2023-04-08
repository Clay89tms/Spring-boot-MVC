package com.example.repairservice.web;

import com.example.repairservice.dto.ErrorResponse;
import com.example.repairservice.dto.OrderCarResponse;
import com.example.repairservice.dto.StoreCarRequest;
import com.example.repairservice.service.OrderCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/store.car")
public class CarStoreResource {

    private final OrderCarService service;

    @GetMapping
    public OrderCarResponse order(@RequestBody StoreCarRequest request){
        return service.orderResponse(request);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> processError(OrderException exc){
        return ResponseEntity
                .status(404)
                .body(new ErrorResponse(exc.getErrorMessage()));
    }
}
