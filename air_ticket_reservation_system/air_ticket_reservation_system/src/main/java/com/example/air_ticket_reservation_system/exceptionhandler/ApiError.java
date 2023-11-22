package com.example.air_ticket_reservation_system.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApiError {
    private Date date;
    private String message;
    private String cause;
}
