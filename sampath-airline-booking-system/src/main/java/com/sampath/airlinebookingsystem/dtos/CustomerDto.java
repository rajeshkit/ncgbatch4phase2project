package com.sampath.airlinebookingsystem.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerDto {
    private Integer customerId;
    @NotEmpty
    @Size(min=4,message = "username must be minimum of 4")
    private String customerName;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dob;
    @NotEmpty
    @Email(message = "email is not valid!!")
    private String email;
    @NotEmpty
    @Size(min = 4,max = 16,message = "password must be between 4 and 16 characters")
    private String password;
    @NotEmpty
    private String ssnType;
    @NotNull
    private String ssnNo;
}
