package com.example.airticketreservation.entity;

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
    @GeneratedValue(generator = "flightSequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "flightSequence", allocationSize = 100, initialValue = 70000, sequenceName = "flightSequence")
    private int id;
    private int totalSeats;
    private String departureCity;
    private String arrivalCity;
    private String departureTime;
    @NotNull
    private int fare;
    @NotNull
    private int availableSeats;
    private Date dateOfDeparture;
    @ManyToOne
    @JoinColumn(name = "a_id")
    private Airline airline;
}
