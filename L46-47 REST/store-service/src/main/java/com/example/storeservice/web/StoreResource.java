package com.example.storeservice.web;

import com.example.storeservice.dto.ErrorResponse;
import com.example.storeservice.dto.OrderResponse;
import com.example.storeservice.dto.StoreRequest;
import com.example.storeservice.service.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/store")
public class StoreResource {

    private final OrderService service;

    @PostMapping
    public OrderResponse order(@RequestBody StoreRequest request) {
        return service.makeOrder(request);
    }

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> processError(OrderException exc){
        return ResponseEntity
                .status(404)
                .body(new ErrorResponse(exc.getErrorMessage()));
    }
}
