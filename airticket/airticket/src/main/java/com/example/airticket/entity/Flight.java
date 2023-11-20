package com.example.airticket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "flightSequence", allocationSize = 100, initialValue = 10000, sequenceName = "flightSequence")
    private int id;
    private int totalSeats;
    private String src;
    private String dest;
    private String departureTime;
    private int fare;
    private int availableSeats;

    @NotNull
    private Date date;

    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;
}




