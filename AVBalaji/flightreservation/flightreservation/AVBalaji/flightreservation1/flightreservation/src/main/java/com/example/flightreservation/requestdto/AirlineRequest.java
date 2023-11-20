package com.example.flightreservation.requestdto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.sql.Date;
@Getter
public class AirlineRequest {
        @NotEmpty(message = "airlineName field is Empty")
        private final String airlineName;

        @NotEmpty
        @NotBlank
        private final Date dateOfOperation;


        public AirlineRequest(String airlineName, Date dateOfOperation) {
            this.airlineName = airlineName;
            this.dateOfOperation = dateOfOperation;
        }

    }
