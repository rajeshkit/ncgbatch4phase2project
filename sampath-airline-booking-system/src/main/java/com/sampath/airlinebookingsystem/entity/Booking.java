package com.sampath.airlinebookingsystem.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int bookingId;
   Date bookingDate;
   int price;
   int seatsBook;
   Date departDate;

   @ManyToOne
   @JoinColumn(name = "flight_Id")
   private Flight flightId;

   @ManyToOne
   @JoinColumn(name = "customer_Id")
   private Customer customerId;
}
