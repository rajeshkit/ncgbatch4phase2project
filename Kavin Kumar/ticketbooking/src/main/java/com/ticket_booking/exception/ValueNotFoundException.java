package com.ticket_booking.exception;

public class ValueNotFoundException extends RuntimeException {
    public ValueNotFoundException(String message) {
        super(message);
    }
}
