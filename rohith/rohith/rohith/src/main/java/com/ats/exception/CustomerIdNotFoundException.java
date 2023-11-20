package com.ats.exception;

public class CustomerIdNotFoundException extends Exception{
    private String message;
    public CustomerIdNotFoundException(String message) {
        super(message);
        this.message=message;
    }
}
