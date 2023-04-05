package com.example.storeservice.client;

import com.example.storeservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "userClient",
        url = "http://127.0.0.1:8081",
        configuration = FeignClient.class
)
public interface UserClient {

    @GetMapping("/users/{id}")
    UserDto get(@PathVariable(name = "id") String login);
}
