package com.example.atrs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "flightSequence")
   @SequenceGenerator(name = "flightSequence",sequenceName = "flightSequence",allocationSize = 100,initialValue = 5555)
    private int flightId;
    @ManyToOne
    @JoinColumn(name="air_id")
    private AirlineMaster airId;
    @NotNull
    private int totSeats;
    @ManyToOne
    @JoinColumn(name="source")
    private LocationMaster sourceId;
    @ManyToOne
    @JoinColumn(name="destination")
    private  LocationMaster destinationId;
    @NotBlank
    private String dprTime;
    @NotNull
    private int fare;
    @NotNull
    private int avaSeats;
    @FutureOrPresent
    private Date dprDate;

 @SuppressWarnings("unused")
 public FlightMaster(int flightId) {
  this.flightId = flightId;
 }


}
