package com.example.airticketreservation.exception;

import lombok.Data;

import java.util.Date;
@Data
public class ApiError {
    private Date on;
    private String message;
    private String cause;

    public ApiError(Date on, String message, String cause) {
        this.on = on;
        this.message = message;
        this.cause = cause;
    }
}
