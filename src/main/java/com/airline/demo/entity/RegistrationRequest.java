package com.airline.demo.entity;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String email;
    private String password;

    private String name;
}

