package com.ats.exception;

public class BookingIdNotFoundException extends Exception{
    private String message;
    public BookingIdNotFoundException(String message) {
        super(message);
        this.message=message;
    }

}
