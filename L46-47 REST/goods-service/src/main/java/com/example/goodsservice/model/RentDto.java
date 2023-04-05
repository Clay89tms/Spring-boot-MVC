package com.example.goodsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentDto {
    private UUID id;
    @NotNull
    private String street;
    private Integer age;
    private Boolean isOnStock;
    private Details details;
}
