package com.flightreservation.flight.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class Booking {
    @Id
    @Column(name="booking_id",length=50,nullable=false)
    private int bookingId;

    @Column(name="booking_date",nullable = false)
    private Date bookingDate;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_no")
    private Flight flight;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "customerIdNo")
    private CustomerRegistration customer;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="airline_id")
    private Airline airline;
    private int customerId;
    @Column(name="cost",length = 11,nullable = false)
    private int cost;
    @Column(name="seats_booked",length = 11,nullable = false)
    private int seatsBooked;
    @Column(name="depart_date",nullable = false)
    private Date departureDate;
}
