package com.ats.exception;

public class FlightIdNotFoundException extends Exception{

    private String message;
    public FlightIdNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
