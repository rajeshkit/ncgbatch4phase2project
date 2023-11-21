package com.example.atrs.exception;

public class BookingIdNotFoundException extends Exception{
   final String message;
    public BookingIdNotFoundException(String message){
        super(message);
        this.message=message;
    }
}
