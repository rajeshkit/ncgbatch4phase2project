
package com.flightreservation.flight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Airline {
    @Id
    @Column(name ="id",nullable = false)
    private  int airlineId;
    @Column(name="airlineName",length = 45)
    private  String airlineName;




}

