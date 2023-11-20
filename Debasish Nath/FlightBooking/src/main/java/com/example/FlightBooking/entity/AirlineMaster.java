package com.example.FlightBooking.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "airline")
public class AirlineMaster {

    @Id
    @Column(name = "a_id", length = 50, nullable = false)
    private String airId;

    @Column(name = "a_name", length = 100, nullable = false)
    private String airlineName;

    @Column(name = "dop", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfOperation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airlineId", cascade = CascadeType.ALL)
    private List<FlightMaster> flightMasterSource;


}
