package com.example.airticketreservation.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FlightIdNotFoundException extends RuntimeException{
    private final String msg;
    public FlightIdNotFoundException(String message)
    {
        super(message);
        this.msg=message;
    }
}