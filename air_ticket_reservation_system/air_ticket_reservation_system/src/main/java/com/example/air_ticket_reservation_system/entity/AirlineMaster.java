package com.example.air_ticket_reservation_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AirlineMaster {
    @Id
    String airlineId;
    String airlineName;
    @NotNull
    @Temporal(TemporalType.DATE)
    Date dateOfOperation;
}
