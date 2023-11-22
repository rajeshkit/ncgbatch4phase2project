package com.ticket_booking.exception;

public class NotLoggedInException extends RuntimeException{
    public NotLoggedInException(String message) {
        super(message);
    }
}
