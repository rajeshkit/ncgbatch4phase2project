package com.flightreservation.flight.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Location {
    @Id
    @Column(name="location_id",length = 11,nullable = false)
    private int locationId;
    @Column(name="location_name",length = 100,nullable = false)
    private String locationName;


    public  String getLocationName(){
        return locationName;
    }

}
