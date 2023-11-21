package com.example.FlightBooking.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
public class BookingInfo {

    @Id
    @Column(name = "booking_id", length = 50, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "booking_date", nullable = false)
    private Date bookingDate;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "seat_book", nullable = false)
    private Integer seatBook;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "depart_date", nullable = false)
    private Date departDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "f_no", referencedColumnName = "f_no")
    private FlightMaster flightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_id", referencedColumnName = "c_id")
    private CustomerMaster customerId;

}
