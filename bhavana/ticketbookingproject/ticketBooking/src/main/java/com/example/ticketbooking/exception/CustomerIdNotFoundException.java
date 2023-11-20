package com.example.ticketbooking.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerIdNotFoundException extends RuntimeException{
    private final int status;
    public CustomerIdNotFoundException(String message, int status) {
        super(message);
        this.status = status;
    }
}
