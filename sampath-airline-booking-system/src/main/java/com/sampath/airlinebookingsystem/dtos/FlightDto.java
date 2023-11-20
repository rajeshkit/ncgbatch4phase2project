package com.sampath.airlinebookingsystem.dtos;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class FlightDto {
   private Integer fno;
    @NotNull
    private Integer totSeats;
    @NotNull
    private String departTime;
    @NotNull
    private Integer fare;
    @NotNull
    private Integer avaSeats;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date departDate;
    private AirlineDto airlineId;
    private LocationDto src;
    private LocationDto dest;
}
