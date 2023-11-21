package com.example.atrs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookingSequence")
    @SequenceGenerator(name = "bookingSequence",sequenceName = "bookingSequence",allocationSize = 100,initialValue = 1001)
    private int bookingId;
    @FutureOrPresent(message = "The Date should be present or future Date")
    private Date bookingDate;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_no")
    private FlightMaster flightNo;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_no")
    private CustomerMaster customerNo;
    @NotNull
    private double price;
    @NotNull
    private int seats;
    @NotNull
   @FutureOrPresent(message = "the date should be present or the future date")
    private Date departDate;
}
