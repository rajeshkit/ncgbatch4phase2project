package com.example.flightreservation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_master")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "customerIdSequence",allocationSize = 100, initialValue =50000 ,sequenceName = "customerIdSequence")
    @Column(name = "c_id")
    @NotNull
    private Long id;
    @Column(name = "customer_name")
    @NotBlank(message = "Customer name is mandatory, field should not be empty")
    private String customerName;
    @Column(name = "dob")
    @Past(message = "DOB must not be future date")
    private Date dob;
    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Password must be at least 8 characters long and contain at least one digit, one lowercase letter, one uppercase letter, and one special character."
    )
    private String password;
    @Column(name = "ssn_type")
    private String ssnType;
    @Column(name = "ssn_no")
    private String ssnNo;

    @OneToOne
    @JoinColumn(name = "login_id")
    private Login login;
}