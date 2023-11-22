package com.example.air_ticket_reservation_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FlightMaster {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "flightSequence", allocationSize = 100, initialValue = 10000,
            sequenceName = "flightSequence")
    String flightId;
    int totalSeatsBooked;

    @ManyToOne
    @JoinColumn(name = "airlineId", referencedColumnName = "airlineId")
   private AirlineMaster airlineMaster;//String airlineId; foreign key from airline master

    @ManyToOne
   @JoinColumn(name = "departureId", referencedColumnName = "locationId")
   private LocationMaster departureId;

   @ManyToOne
   @JoinColumn(name = "srcId", referencedColumnName = "locationName")
   private LocationMaster srcId;
    String departureTime;
    int fare;
    int availableSeats ;
    @NotNull
    Date departureDate;

}
