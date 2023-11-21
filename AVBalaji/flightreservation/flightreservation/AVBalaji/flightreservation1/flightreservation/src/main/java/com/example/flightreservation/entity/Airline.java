package com.example.flightreservation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "airline_master")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "airlineSequence",allocationSize = 1, initialValue =20000, sequenceName = "airlineSequence")
    @Column(name = "a_id")
    private int id;
    @Column(name = "a_name")
    @NotBlank(message = "Customer name is mandatory, field should not be empty")
    private String name;
    @Column(name = "dop")
    private Date dateOfOperation;

    public Airline(String name, Date dateOfOperation) {
        this.name = name;
        this.dateOfOperation = dateOfOperation;
    }

    @OneToMany(mappedBy = "airline" ,cascade = CascadeType.MERGE)
    private List<Flight> flightList = new ArrayList<>();
    public void addFlight(Flight flight) {
        this.flightList.add(flight);
        flight.setAirline(this);
    }
}