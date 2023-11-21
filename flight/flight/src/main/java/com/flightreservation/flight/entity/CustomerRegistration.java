package com.flightreservation.flight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerRegistration {
    @Id
    @Column(name="c_id",length = 50,nullable = false)
    @NotNull
    private Integer id;
    @Column(name="c_name",length = 100,nullable = false)
    private String name;
    @Column(name="email",length = 45,nullable = false)
    @Email
    private  String email;
    @Column(name="password",length = 45,nullable = false)
    private  String password;
    @Column(name="dob",nullable = false)
    private  Date dob;
    @Column(name="ssn_type",length = 45,nullable = false)
    private String ssnType;
    @Column(name="ssn_no",length = 50,nullable = false)
    private int ssnNumber;

}
