package com.ticket_booking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1, initialValue = 1000)
    private int locationId;
    @NotBlank(message = "enter the location")
    private String locationName;
}
