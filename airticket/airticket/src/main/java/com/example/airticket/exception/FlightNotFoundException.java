package com.example.airticket.exception;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String message)
    {
        super(message);
    }
}
