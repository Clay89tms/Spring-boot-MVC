package com.example.repairservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.repairservice")
public class CarStoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarStoreServiceApplication.class, args);
    }

}
