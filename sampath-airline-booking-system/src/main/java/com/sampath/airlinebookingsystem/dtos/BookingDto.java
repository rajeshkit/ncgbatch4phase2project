package com.sampath.airlinebookingsystem.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookingDto {
    int bookingId;
    @NotNull
    @Temporal(TemporalType.DATE)
    String bookingDate;
    int price;
    @NotNull
    int seatsBook;
    @NotNull
    @Temporal(TemporalType.DATE)
    String departDate;

    FlightDto flightId;
    CustomerDto customerId;
}
