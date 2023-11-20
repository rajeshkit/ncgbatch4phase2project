package com.ats.service;

import com.ats.entity.Booking;
import com.ats.entity.Flight;
import com.ats.repository.BookingRepository;
import com.ats.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;
    @Override
    public boolean createBooking(Booking booking) {
        Flight flight = booking.getFlightId();
        Flight ft = flightRepository.findById(flight.getFlightId()).get();
        int fare =ft.getFare();
        int seats = booking.getSeatBook();
        int price = seats*fare;
        booking.setPrice(price);
        Booking bc = bookingRepository.save(booking);
        Optional<Booking> bk = bookingRepository.findById(bc.getBookingId());
        if (bk.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Optional<Booking> getBookingById(long bId) {
        return bookingRepository.findById(bId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
