package com.example.airticketreservation.service;

import com.example.airticketreservation.exception.CustomerIdNotFound;
import com.example.airticketreservation.entity.Booking;
import com.example.airticketreservation.repository.BookingRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService implements IBookingService{
    private final BookingRep bookingRep;

    @Autowired
    public BookingService(BookingRep bookingRep) {
        this.bookingRep = bookingRep;
    }

    @Override
    public boolean saveTicketBookingDetails(Booking booking) {
        bookingRep.save(booking);
        return true;
    }
    public List<Booking> getBookingDetails(Long customerId) throws CustomerIdNotFound {

        return bookingRep.findByCustomerId(customerId);
    }
}
