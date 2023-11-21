package com.ticket_booking.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticket_booking.extras.CreationValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@AllArgsConstructor
@Component
public class Booking {

    @Id
    private int bookingId;
    private LocalDate bookingDate;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_no")
    private Flight flight;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private int noOfSeats;
    private Double totalFare;
    private LocalTime bookingTime;
    private LocalDate departureDate;
    private String departureTime;

    @Transient
    @Positive(message = "enter valid flight No",groups = CreationValidation.class)
    @NotNull(message ="enter flight number",groups = CreationValidation.class)
    private Integer flightNumber;

    @Transient
    private Integer customerId;

    @PrePersist
    public void prePersist(){
            this.bookingDate = LocalDate.now();
            this.bookingTime = LocalTime.now();
            this.totalFare = (flight.getFare()) * noOfSeats + 50;
    }
    public Booking() {
        SecureRandom secureRandom = new SecureRandom();
        this.bookingId = 10000 + secureRandom.nextInt(10000);
    }
}
