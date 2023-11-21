package com.ticket_booking.entity;

import com.ticket_booking.extras.LoginValidation;
import com.ticket_booking.extras.RegistrationValidation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.security.SecureRandom;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
public class Airline {
    @Id
    @NotNull(message = "enter airline id",groups = LoginValidation.class)
    private Integer airlineId;
    @NotBlank(message = "enter airline name" ,groups =  RegistrationValidation.class)
    private String airlineName;
    @NotNull(message = "enter date",groups = {RegistrationValidation.class})
    @DateTimeFormat()
    private LocalDate dop;
    @Size(min = 6, message = "Password must have at least 6 characters",groups = {LoginValidation.class, RegistrationValidation.class})
    private String password;

    public Airline(){
        SecureRandom secureRandom = new SecureRandom();
        airlineId=2000+secureRandom.nextInt(1000);
    }

    public Airline( String airlineName, LocalDate dop,String password,int airlineId) {

        this.airlineName = airlineName;
        this.dop = dop;
        this.password=password;
        this.airlineId = airlineId;
    }
}
