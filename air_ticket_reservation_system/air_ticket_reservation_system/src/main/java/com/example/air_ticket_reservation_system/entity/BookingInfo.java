package com.example.air_ticket_reservation_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookingInfo {
    @Id
    String bookingId;
    @NotNull
    Date bookingDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flightNumber", referencedColumnName = "flightId")
    private FlightMaster flightMaster;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private CustomerMaster customerMaster;
//    String flightNumber; // Foreign Key from flight master
//    String customerId;  // Foreign Key from customer master
    int price;
    int seatsBooked;
    Date departDate;
}
