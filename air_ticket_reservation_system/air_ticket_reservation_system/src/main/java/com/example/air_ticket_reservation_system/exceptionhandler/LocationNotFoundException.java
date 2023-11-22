package com.example.air_ticket_reservation_system.exceptionhandler;

public class LocationNotFoundException extends Exception{
    String msg;
    public LocationNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
}
