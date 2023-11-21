package com.example.atrs.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "airlineSequence")
    @SequenceGenerator(name = "airlineSequence",sequenceName = "airlineSequence",allocationSize = 12,initialValue = 1111)
    private int airId;
    @NotBlank
    @NotNull(message = "It should be null")
    @Size(min = 2,max = 100,message = "the size should be between 2 and 100")
    private String airName;
    @SuppressWarnings("unused")
    public AirlineMaster(int airId) {
        this.airId = airId;
    }
    @Past(message = "the date on which the flight got registered")
    private Date dop;
}
