package com.example.usersservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder

@Entity
@Table(name = "persons")
public class UserEntity {

    @Id
    private UUID id;

    private String login;
    private String password;

}
