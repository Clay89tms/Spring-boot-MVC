package com.example.springtestexample.service;

import com.example.springtestexample.dto.PersonDto;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.Objects;

public class PersonValidatorService {

    private boolean isValid(PersonDto person){
        if(Objects.isNull(person)){
            return false;
        } else {
            return true;
        }

    }
}
