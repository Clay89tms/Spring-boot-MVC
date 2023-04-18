package com.example.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;

@Service
public class TestService {

//    @Secured({ "ROLE_ADMIN" })
//    @RolesAllowed({ "ROLE_ADMIN" })
//    @PreAuthorize("hasRole('ROLE_ADMIN')") //не заходит в метод с аннотацией (нужная рполь) В ОСНОВНОМ НЕ ИСПОЛЬЗУЮТ
    @PostAuthorize("hasRole('ROLE_ADMIN')") //заходит в метод но не выходит (нужная роль) В ОСНОВНОМ НЕ ИСПОЛЬЗУЮТ
    public void test(){
        System.out.println("");
    }

}
