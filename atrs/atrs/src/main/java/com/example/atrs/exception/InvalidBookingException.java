package com.example.atrs.exception;

public class InvalidBookingException extends Exception{
   final String message;
    public InvalidBookingException (String message){
        super(message);
        this.message=message;
    }
}
