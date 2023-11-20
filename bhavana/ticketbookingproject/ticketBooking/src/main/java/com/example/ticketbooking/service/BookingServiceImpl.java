package com.example.ticketbooking.service;

import com.example.ticketbooking.entity.Booking;
import com.example.ticketbooking.entity.Customer;
import com.example.ticketbooking.exception.CustomerIdNotFoundException;
import com.example.ticketbooking.repository.BookingReposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements IBookingService {

    private final BookingReposit bookingRepository;
@Autowired
    public BookingServiceImpl(BookingReposit bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean bookFlight(Booking booking) {
        bookingRepository.save(booking);
        return true;
    }
    public List<Customer> getCustomerBookings(Long customerId) throws CustomerIdNotFoundException {
        List<Booking> bookings = bookingRepository.findByCustomerId(customerId);
        return bookings.stream()
                .map(Booking::getCustomer)
                .collect(Collectors.toList());
    }

}
