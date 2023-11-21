package com.ats.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "customersequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customersequence",allocationSize = 100, initialValue = 10000,sequenceName = "customersequence")
    private long customerId;
    @NotBlank(message = "The Customer name should not be empty")
    private String customerName;
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Email
    private String email;
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
