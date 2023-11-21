package com.example.FlightBooking.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location_master")
public class LocationMaster {

    @Id
    @Column(name = "location_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column(name = "location_name", length = 100, nullable = false)
    private String locationName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sourceId", cascade = CascadeType.ALL)
    private List<FlightMaster> flightMasterSource;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destinationId", cascade = CascadeType.ALL)
    private List<FlightMaster> flightMasterDestination;

}