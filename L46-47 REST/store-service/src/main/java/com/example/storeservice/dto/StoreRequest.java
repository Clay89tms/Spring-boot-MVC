package com.example.storeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreRequest {

    private String login;
    private String goodName;
}
