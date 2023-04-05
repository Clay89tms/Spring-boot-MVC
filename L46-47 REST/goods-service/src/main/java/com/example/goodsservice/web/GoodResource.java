package com.example.goodsservice.web;

import com.example.goodsservice.exp.ErrorResponse;
import com.example.goodsservice.exp.GoodNotFoundException;
import com.example.goodsservice.model.GoodEntity;
import com.example.goodsservice.service.GoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/goods")
public class GoodResource {

    private final GoodService service;

    @PostMapping("/{id}")
    @Operation(summary = "summary goods", description = "description goods")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = GoodEntity.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema))
    })
    public GoodEntity get(@PathVariable(name = "id") String name){
        return service.getByName(name);
    }

    @ExceptionHandler(GoodNotFoundException.class)
    public ErrorResponse processError(GoodNotFoundException exc){
        return new ErrorResponse(exc.getError());
    }

}
