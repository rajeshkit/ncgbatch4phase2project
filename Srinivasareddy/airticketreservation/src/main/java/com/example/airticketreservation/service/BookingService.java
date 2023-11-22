package com.example.airticketreservation.service;

import com.example.airticketreservation.entity.Customer;
import com.example.airticketreservation.entity.Booking;
import com.example.airticketreservation.exception.CustomerIdNotFound;
import com.example.airticketreservation.repository.BookingRep;
import com.example.airticketreservation.repository.CustomerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService implements IBookingService{
    private final BookingRep bookingRep;
    private final CustomerRep customerRep;

    @Autowired
    public BookingService(BookingRep bookingRep, CustomerRep customerRep) {
        this.bookingRep = bookingRep;
        this.customerRep = customerRep;
    }

    @Override
    public boolean saveTicketBookingDetails(Booking booking) {
        bookingRep.save(booking);
        return true;
    }
    public List<Booking> getBookingDetails(Long customerId)  {
        Customer customer= customerRep.findById(customerId).orElseThrow(()->new CustomerIdNotFound("Customer id not found"));

        return bookingRep.findByCustomerId(customerId);
    }
}
