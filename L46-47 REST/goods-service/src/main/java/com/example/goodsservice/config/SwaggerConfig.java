package com.example.goodsservice.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi rentGroup(){
        return GroupedOpenApi.builder()
                .group("RENT GROUP")
                .pathsToMatch("/rent/**", "/rent")
                .build();
    }

    @Bean
    public GroupedOpenApi goodGroup(){
        return GroupedOpenApi.builder()
                .group("GOOD GROUP")
                .pathsToMatch("/goods/**", "/goods")
                .build();
    }
}
