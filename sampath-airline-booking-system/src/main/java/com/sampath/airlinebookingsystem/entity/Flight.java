package com.sampath.airlinebookingsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(generator="flight_id_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "flight_id_gen",sequenceName = "airline_id",initialValue =
            100000,allocationSize = 1)
    private Integer fno;

    private Integer totSeats;
    private String departTime;
    private Integer fare;
    private Integer avaSeats;
    private Date departDate;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airlineId;

    @ManyToOne
    @JoinColumn(name = "src_id")
    private Location src;

    @ManyToOne
    @JoinColumn(name = "dest_id")
    private Location dest;

    @OneToMany(mappedBy = "flightId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Booking> bookings= new ArrayList<>();
}