package com.example.air_ticket_reservation_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerMaster {
    @Id
    String customerId;
    String customerName;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dob;
//    @ManyToOne
//    @JoinColumn(name = "email", referencedColumnName = "email")
//    private Login login;
    String email; // Foreign key from login
    String password;
    String ssnName;
    String ssnNumber;

}
