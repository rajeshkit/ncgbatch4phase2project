package com.sampath.airlinebookingsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private Date dob;
    private String email;
    private String password;
    private String ssnType;
    private String ssnNo;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    public Customer(Integer customerId, String customerName, Date dob, String email,
                    String password, String ssnType, String ssnNo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.ssnType = ssnType;
        this.ssnNo = ssnNo;
    }
}
