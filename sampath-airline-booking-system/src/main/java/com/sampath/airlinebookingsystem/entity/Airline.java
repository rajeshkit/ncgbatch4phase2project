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
public class Airline {
    @Id
    @GeneratedValue(generator="airline_id_gen",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "airline_id_gen",sequenceName = "airline_id",initialValue =
            1000,allocationSize = 1)
    int aId;
    String airlineName;
    Date dop;

    @OneToMany(mappedBy = "airlineId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Flight> airlineFlights = new ArrayList<>();

    public Airline(int aId, String airlineName, Date dop) {
        this.aId = aId;
        this.airlineName = airlineName;
        this.dop = dop;
    }
}
