package com.example.airticket.service;

import com.example.airticket.entity.Booking;
import com.example.airticket.exception.CustomerIdNotFoundException;
import com.example.airticket.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceImp {
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean flightBooking(Booking booking) {
        bookingRepository.save(booking);
        return true;
    }
    public List<Booking> getCustomerBooking(Long customerId) throws CustomerIdNotFoundException {

        return bookingRepository.findByCustomerId(customerId);
    }
}
