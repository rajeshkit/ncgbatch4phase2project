package com.ats.exception;

public class FlightNotFoundException extends Exception{
    private String message;
    public FlightNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
