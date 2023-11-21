package com.example.FlightBooking.exception;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ApiErrorResponse {
    private String on;
    private int code;
    private String message;

}
