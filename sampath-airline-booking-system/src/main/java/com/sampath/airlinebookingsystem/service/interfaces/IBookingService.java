package com.sampath.airlinebookingsystem.service.interfaces;

import com.sampath.airlinebookingsystem.dtos.BookingDto;

import java.util.List;

public interface IBookingService {
    BookingDto bookTicket(BookingDto bookingDto, Integer customerId,Integer flightId);

    List<BookingDto> getBookingDetailsOfFlight(Integer flightId);

    BookingDto getBookingDetailsById(Integer bId);

    List<BookingDto> getAllBooking();
}
