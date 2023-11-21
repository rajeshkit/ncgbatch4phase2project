package com.ticket_booking.extras;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoggedInId  {
    private int customerId;
    private int airlineId;
}
