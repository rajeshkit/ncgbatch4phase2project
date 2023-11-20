package com.example.FlightBooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode

@Table(name = "customer_master")
public class CustomerMaster {
    @Id
    @Column(name = "c_id", length = 50 )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotNull
    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    //@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy/MM/dd")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob",nullable = false)
    private Date dob;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private Login login;

//    @Column(name = "password", length = 45, nullable = false)
//    private String password;

    @Column(name = "ssn_type", length = 45, nullable = false)
    private String ssnType;

    @Column(name = "ssn_no", length = 50, nullable = false)
    private String ssnNo;


}
