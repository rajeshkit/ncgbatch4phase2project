package com.example.airticket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customersequence",allocationSize = 100, initialValue = 10000,sequenceName = "customersequence")
    private int customerId;
    private String customerName;
    private Date dob;
    private String email;
    private String password;
    private String ssnType;
    private String ssnNo;



}
