package com.example.airticket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    private String bookingId;
    private Date bookingDate;
    private String flightNumber;
    private Long customerId;
    private int price;
    private int seatsBooked;
    private Date departureDate;


}
