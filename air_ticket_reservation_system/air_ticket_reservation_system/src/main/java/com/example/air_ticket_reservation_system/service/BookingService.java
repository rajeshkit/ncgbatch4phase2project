package com.example.air_ticket_reservation_system.service;

import com.example.air_ticket_reservation_system.entity.BookingInfo;
import com.example.air_ticket_reservation_system.repository.BookingRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.IBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements IBooking {
    @Autowired
    BookingRepository bookingRepository;
    @Override
    public BookingInfo createBooking(BookingInfo bookingInfo) {
        return bookingRepository.save(bookingInfo);
    }

    @Override
    public List<BookingInfo> getBooking(BookingInfo bookingInfo) {
        return bookingRepository.findAll();
    }
}
