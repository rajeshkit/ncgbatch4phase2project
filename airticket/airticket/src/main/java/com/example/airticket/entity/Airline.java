package com.example.airticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "airlinesequence",allocationSize = 1, initialValue =20000, sequenceName = "airlinesequence")
    private Long airlineId;
    private String airlineName;
    private Date dateOfOperation;

    public Airline(Long airlineId, String airlineName) {
        this.airlineId = airlineId;
        this.airlineName = airlineName;
    }
}