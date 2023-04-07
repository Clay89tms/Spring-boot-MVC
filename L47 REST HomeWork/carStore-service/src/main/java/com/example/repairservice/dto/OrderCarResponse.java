package com.example.repairservice.dto;

import com.example.repairservice.client.CarClient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Generated;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class OrderCarResponse {

   private Integer idOrder;
   private String model;
   private String color;
   private Double price;
}
