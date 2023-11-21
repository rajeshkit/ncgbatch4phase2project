package com.example.atrs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "locationSequence")
    @SequenceGenerator(name = "locationSequence",sequenceName = "locationSequence",allocationSize = 10,initialValue = 1000)
    private int locationId;
    @NotBlank(message = "     the name should be blank")
    @Size(max = 100,min=2)
    private String locationName;
    @SuppressWarnings("unused")
    public LocationMaster(int locationId) {
        this.locationId = locationId;
    }
}
