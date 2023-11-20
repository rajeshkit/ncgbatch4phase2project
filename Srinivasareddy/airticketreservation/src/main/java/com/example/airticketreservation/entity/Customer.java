package com.example.airticketreservation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Entity
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customerId",allocationSize = 100,initialValue = 50000,sequenceName = "customerId")
    @Column(name = "c_id")
    private int customerId;
    private String customerName;
    private Date dob;
    private String email;
    private String password;
}
