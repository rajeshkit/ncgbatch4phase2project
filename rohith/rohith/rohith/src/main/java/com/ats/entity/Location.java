package com.ats.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(generator = "locationsequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "locationsequence",allocationSize = 100, initialValue = 30000,sequenceName = "locationsequence")
    private long locationId;

    private String locationName;


}
