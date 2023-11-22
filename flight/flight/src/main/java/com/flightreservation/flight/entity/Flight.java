package com.flightreservation.flight.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Flight {
    @Id
 //   @JsonIgnore dept date service

    private int flightno;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_id")
    private Airline airline;
    private int bookedSeats;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id")
    private Location source;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "dest_id")
    private Location destination;
    private int totalSeats;
    private String deptTime;
    private int fare;
    private int availableSeats;
    private Date departDate;

}
