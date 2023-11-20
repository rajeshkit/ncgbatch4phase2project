package com.example.airticketreservation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int bookingId;
    private Date bookingDate;
    private int id;
    private int customerId;
    private int price;
    private int seatsBook;
    private Date departDate;
}
