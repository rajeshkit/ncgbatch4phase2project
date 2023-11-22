package com.example.airticketreservation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bookingId",allocationSize = 100,initialValue = 50000,sequenceName = "bookingId")
    private int bookingId;
    private int id;
    private int customerId;
    private int price;
    @NotNull
    private int seatsBook;
    private Date departDate;
}
