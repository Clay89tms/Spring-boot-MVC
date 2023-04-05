package com.example.storeservice.client;

import com.example.storeservice.dto.GoodDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "goodClient",
        url = "http://127.0.0.1:8082",
        configuration = FeignClient.class
)
public interface GoodClient {

    @PostMapping("/goods/{id}")
    GoodDto get(@PathVariable(name = "id") String name);
}
