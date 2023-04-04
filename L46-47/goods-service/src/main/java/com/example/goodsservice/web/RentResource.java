package com.example.goodsservice.web;

import com.example.goodsservice.model.RentDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
@Tag(name = "Private API")
public class RentResource {

    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(description = "return rent for current user", responseCode = "201",
            content = @Content(mediaType = "application/JSON", schema = @Schema(name = "test title",
                    implementation = RentDto.class)))
    })
    public RentDto get(){
        return new RentDto();
    }

    @PostMapping
    public RentDto save(@RequestBody RentDto dto){
        return new RentDto();
    }
}
