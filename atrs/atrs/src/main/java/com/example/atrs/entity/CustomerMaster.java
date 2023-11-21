package com.example.atrs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customerSequence")
    @SequenceGenerator(name = "customerSequence",sequenceName = "customerSequence",allocationSize = 100,initialValue = 4000)
private int custId;
    @NotEmpty
    @Size(max = 12,min = 1,message = "Check the Size ")
private String custName;
    @NotNull
    @Past
private Date dob;
@NotEmpty
@Email
private String email;
@NotEmpty
@Size(max = 10,min = 6)
private  String password;
@NotEmpty
private String ssnType;
@NotEmpty
private  String ssnNo;

@SuppressWarnings("unused")
public CustomerMaster(int custId) {
        this.custId = custId;
    }
}
