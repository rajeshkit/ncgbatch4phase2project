package com.example.airticketreservation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Airline_master")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "airlineIdSequence",allocationSize = 100,initialValue = 10000,sequenceName = "airlineIdSequence")
    @Column(name = "a_id")
    private long airlineId;
    private String aName;
    @NotNull
    private Date dop;
}