package com.example.air_ticket_reservation_system.exceptionhandler;

public class FlightNotFoundException extends Exception{
    String msg;
    public FlightNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }
}
