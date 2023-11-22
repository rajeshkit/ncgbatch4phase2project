package com.example.air_ticket_reservation_system.serviceinterfaces;

import com.example.air_ticket_reservation_system.exceptionhandler.EntityNotFoundException;

public interface ICancellation {
    boolean saveCancelTicket(String bookingId) throws EntityNotFoundException;
}
