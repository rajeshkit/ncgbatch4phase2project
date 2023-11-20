package com.example.FlightBooking.exception;

public class FlightSrcDestNotFoundException extends Exception {
    String msg;

    public String getMsg() {
        return msg;
    }
    public FlightSrcDestNotFoundException(String msg) {
        super(msg);
        this.msg=msg;
    }
}
