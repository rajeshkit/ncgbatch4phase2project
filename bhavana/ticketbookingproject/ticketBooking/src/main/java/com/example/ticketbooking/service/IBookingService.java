package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Booking;
import com.example.ticketbooking.entity.Customer;
import com.example.ticketbooking.exception.CustomerIdNotFoundException;

import java.util.List;

public interface IBookingService {
    boolean bookFlight(Booking booking);
    List<Customer> getCustomerBookings(Long customerId) throws CustomerIdNotFoundException;

}
