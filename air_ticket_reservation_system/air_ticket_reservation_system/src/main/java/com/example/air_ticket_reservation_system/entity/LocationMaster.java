package com.example.air_ticket_reservation_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LocationMaster {
    @Id
//    @Column(name = "location_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "locationId", initialValue = 50101, sequenceName = "locationId")
   private int locationId;
//    @Column(name = "location_Name", nullable = false,length = 100)
    private String locationName;
}
