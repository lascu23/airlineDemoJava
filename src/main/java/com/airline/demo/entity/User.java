package com.airline.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="acc")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    @Column(name = "passw")
    private String password;

    @Column(name="nume")
    private String name;
}
