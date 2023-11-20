package com.ats.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(generator = "airlinesequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "airlinesequence",allocationSize = 100, initialValue = 40000,sequenceName = "airlinesequence")
    private long airlineId;

    @NotBlank(message = "Airline name cannot be empty")
    private String airlineName;


    @Temporal(TemporalType.DATE)
    @Past(message = "the Date of Operations must be a past date")
    private Date dop;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airlineId")
//    @JsonManagedReference
    private List<Flight> flight;
}
