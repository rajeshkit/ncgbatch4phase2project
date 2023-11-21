package com.sampath.airlinebookingsystem.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Integer locationId;
    @NotEmpty
    @Size(min = 3,message = "min of 4 characters")
    private String locationName;
}
