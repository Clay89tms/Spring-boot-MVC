package com.example.repairservice.dto;

import com.example.repairservice.client.CarClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class OrderCarResponse {

   private UUID idOrder;
   private String model;
   private String color;
   private Double price;
}
