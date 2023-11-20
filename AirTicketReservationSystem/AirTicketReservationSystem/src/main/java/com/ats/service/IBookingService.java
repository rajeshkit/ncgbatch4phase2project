package com.ats.service;

import com.ats.entity.Booking;
import com.ats.entity.BookingDTO;
import com.ats.exception.BookingException;

import java.util.List;

public interface IBookingService {
    public Booking addBooking(BookingDTO dto, String key) throws BookingException;

    public Booking viewBooking(Integer rid, String key) throws BookingException;

    public List<Booking> getAllBooking(String key) throws BookingException;

    public List<Booking> viewBookingsByUerId(Integer uid, String key) throws BookingException;

    public Booking deleteBooking(Integer rid, String key) throws BookingException;

    public Booking updateBooking(Integer rid, BookingDTO dto, String key) throws BookingException;

}
