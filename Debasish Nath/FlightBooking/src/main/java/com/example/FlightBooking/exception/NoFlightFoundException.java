package com.example.FlightBooking.exception;

import lombok.Data;

@Data
public class NoFlightFoundException extends Exception{
    String msg;

    public String getMsg() {
        return msg;
    }

    public NoFlightFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
