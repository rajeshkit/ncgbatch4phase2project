package com.example.FlightBooking.exception;

import lombok.Data;

@Data

public class CustomerIdNotFoundException extends Exception{
    String msg;

    public String getMsg() {
        return msg;
    }

    public CustomerIdNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }

}
