package com.example.airticketreservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FlightNotFoundException extends RuntimeException {
    private final String msg;
    public FlightNotFoundException(String message)
    {
        super(message);
        this.msg=message;
    }
}