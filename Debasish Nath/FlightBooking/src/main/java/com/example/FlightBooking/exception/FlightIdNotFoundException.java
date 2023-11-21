package com.example.FlightBooking.exception;

public class FlightIdNotFoundException extends Exception{
    String msg;

    public String getMsg() {
        return msg;
    }

    public FlightIdNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
