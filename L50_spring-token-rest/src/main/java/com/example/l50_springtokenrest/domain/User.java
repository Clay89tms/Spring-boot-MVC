package com.example.l50_springtokenrest.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class User {

    private String login;
    private List<String> auths;
    private String password;
}
