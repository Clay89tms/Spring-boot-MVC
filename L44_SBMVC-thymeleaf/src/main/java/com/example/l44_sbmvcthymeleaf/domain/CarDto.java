package com.example.l44_sbmvcthymeleaf.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarDto {

    private String name;
    private Integer age;




    public String getFull(){
        return name + " age = " + age;
    }
}
