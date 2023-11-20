package com.sampath.airlinebookingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;
    private String locationName;

    @OneToMany(mappedBy = "src",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Flight> srcFlights = new ArrayList<>();

    @OneToMany(mappedBy = "dest",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Flight> destFlights = new ArrayList<>();

}