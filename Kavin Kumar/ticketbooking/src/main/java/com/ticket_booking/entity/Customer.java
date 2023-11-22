package com.ticket_booking.entity;

import com.ticket_booking.extras.LoginValidation;
import com.ticket_booking.extras.RegistrationValidation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.SecureRandom;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
public class Customer {
    @Id
    private Integer id;
    @NotBlank(message = "Name cannot be empty",groups = RegistrationValidation.class)
    private String name;
    @NotNull(message = "enter your date of birth",groups = RegistrationValidation.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "Birthdate must be in the past",groups = RegistrationValidation.class)
    private LocalDate dob;
    @Email(message = "enter a valid email",groups = {RegistrationValidation.class,LoginValidation.class})
    private String email;
    @Size(
            min = 6,max = 12,
            message = "Password must be between 6 to 12 characters.",
            groups ={RegistrationValidation.class, LoginValidation.class}
    )
    private String password;
    @NotBlank(message = "Please select an id type",groups = RegistrationValidation.class)
    private String idCardType;
    @NotBlank(message = "Please enter the id number",groups = RegistrationValidation.class)
    private  String idCardNo;


    public Customer(){
        SecureRandom secureRandom = new SecureRandom();
        id = 13080000 + secureRandom.nextInt(10000);
    }
}
