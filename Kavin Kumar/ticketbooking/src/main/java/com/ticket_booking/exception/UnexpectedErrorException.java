package com.ticket_booking.exception;

public class UnexpectedErrorException extends RuntimeException {
    public UnexpectedErrorException(String message) {
        super(message);
    }
}
