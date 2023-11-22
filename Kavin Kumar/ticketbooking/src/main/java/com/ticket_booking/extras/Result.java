package com.ticket_booking.extras;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private boolean isSuccess;
    private String message;

    public Result(String message) {
        this.message = message;
    }

}
