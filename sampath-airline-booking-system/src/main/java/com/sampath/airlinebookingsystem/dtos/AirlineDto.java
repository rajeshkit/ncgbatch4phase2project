package com.sampath.airlinebookingsystem.dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class AirlineDto {
    int aId;
    @Size(min = 3,message = "min of 3 characters")
    @NotEmpty
    String airlineName;
    @NotNull
    @Temporal(TemporalType.DATE)
    Date dop;
}
