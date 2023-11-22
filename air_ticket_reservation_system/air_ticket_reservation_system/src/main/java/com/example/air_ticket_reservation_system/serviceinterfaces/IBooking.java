package com.example.air_ticket_reservation_system.serviceinterfaces;

import com.example.air_ticket_reservation_system.entity.BookingInfo;

import java.util.List;

public interface IBooking {
    public BookingInfo createBooking(BookingInfo bookingInfo);
    public List<BookingInfo> getBooking(BookingInfo bookingInfo);
}
