package com.ats.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "flightId")
public class Flight {

    @Id
    @GeneratedValue(generator = "flightsequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "flightsequence",allocationSize = 100, initialValue = 20000,sequenceName = "flightsequence")
    private long flightId;

    @ManyToOne
    @JoinColumn(name = "airline_id")
//    @JsonBackReference
    private Airline airlineId;

    @NotNull(message = "Total seats in a flight cannot be null")
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name = "source_id")
//    @JsonBackReference
    private Location sourceId;

    @ManyToOne
    @JoinColumn(name = "destination_id")
//    @JsonBackReference
    private Location destinationId;

    @NotBlank(message = "Departure can't be null")
    private String departureTime;

    @NotNull(message = "fare should not be null")
    private int fare;

    private int availableSeats;

    @Temporal(TemporalType.DATE)
    private Date departDate;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "flightId")
//    @JsonManagedReference
    private List<Booking> booking;
}
