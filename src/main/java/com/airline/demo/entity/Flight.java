package com.airline.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="flight")
public class Flight {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_depart")
    private String dateDepart;

    @Column(name = "date_arrival")
    private String dateArrival;

    @Column(name = "takeoff_location")
    private String takeOffLocation;

    @Column(name = "destination")
    private String destination;

    @Column(name="price")
    private String price;

    @Column(name="stopover")
    private String stopover;

}
