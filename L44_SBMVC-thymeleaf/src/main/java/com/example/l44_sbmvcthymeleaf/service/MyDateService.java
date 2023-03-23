package com.example.l44_sbmvcthymeleaf.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyDateService {

    public String getDate(){
        return new Date().toString();
    }
}
