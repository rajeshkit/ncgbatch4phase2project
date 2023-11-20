package com.example.airticketreservation.service;

import com.example.airticketreservation.exception.CustomerIdNotFound;
import com.example.airticketreservation.entity.Booking;

import java.util.List;

public interface IBookingService {
    boolean saveTicketBookingDetails(Booking booking);
    List<Booking> getBookingDetails(Long customerId)throws CustomerIdNotFound;
}