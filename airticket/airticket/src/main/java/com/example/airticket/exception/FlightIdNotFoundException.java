package com.example.airticket.exception;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FlightIdNotFoundException extends RuntimeException{

    private final int status;
    public FlightIdNotFoundException(String message, int status) {
        super(message);
        this.status = status;
    }
}