package com.ats.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bookingId")
public class Booking {

    @Id
    @GeneratedValue(generator = "bookingsequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "bookingsequence",allocationSize = 100, initialValue = 50000,sequenceName = "bookingsequence")
    private Long bookingId;

    @Temporal(TemporalType.DATE)
    private Date bookingDate;

    private int price;

    private int seatBook;

    @Temporal(TemporalType.DATE)
    private Date departDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
//    @JsonBackReference
    private Flight flightId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
//    @JsonBackReference
    private Customer customerId;
}
