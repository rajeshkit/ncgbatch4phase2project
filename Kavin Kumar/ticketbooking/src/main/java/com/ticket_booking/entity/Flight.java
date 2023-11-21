package com.ticket_booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ticket_booking.extras.CreationValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @NotNull(message = "enter flight number",groups = CreationValidation.class)
    @Positive(message = "enter valid flight no",groups = CreationValidation.class)
    private Integer flightNo;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @NotNull(message = "enter booked seats", groups = CreationValidation.class)
    @Positive(message = "enter valid booked seats" , groups = CreationValidation.class)
    private Integer bookedSeats;

    @NotNull(message = "enter available seats", groups = CreationValidation.class)
    @Positive(message = "enter valid available seats", groups = CreationValidation.class)
    private Integer availableSeats;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id")
    private Location source;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "dest_id")
    private Location destination;

    @NotNull(message = "Departure time must not be null",groups = CreationValidation.class)
    @DateTimeFormat()
    private String departureTime;

    @NotNull(message = "enter the fare",groups = CreationValidation.class)
    @Positive(message = "enter valid fare", groups = CreationValidation.class)
    private Double fare;

    @NotNull(message = "enter departure date",groups = CreationValidation.class)
    @Future(message = "departure date should be future",groups = CreationValidation.class)
    @DateTimeFormat()
    private LocalDate departureDate;

    @Transient
    private Integer airlineId;

    @Transient
    @NotNull(message = "enter source id",groups = CreationValidation.class)
    @Positive(message = "enter valid source id",groups = CreationValidation.class)
    private Integer sourceId;

    @Transient
    @NotNull(message = "enter destination id",groups = CreationValidation.class)
    @Positive(message = "enter valid destination id",groups = CreationValidation.class)
    private Integer destinationId;



    }






