package com.example.atrs.exception;

public class FlightIdNotFoundException extends Exception{
   final String message;
    public FlightIdNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
