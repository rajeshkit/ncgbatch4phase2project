package com.ticket_booking.exception;

public class ValueAlreadyExistsException extends RuntimeException{
    public ValueAlreadyExistsException(String message) {
        super(message);
    }
}
