package com.example.FlightBooking.service;

import com.example.FlightBooking.entity.BookingInfo;

import java.util.List;

public interface IBookingInfoService {
    String insertBooking(BookingInfo bookingInfo) throws Exception;

    void updateFlight(String flightId, int seats) throws Exception;

    public List<String> getBookingDetailsByBookId(Long bookId) throws Exception;

    public List<Object[]> getBookingDetailsByBookId2(Long bookId) throws Exception;

}
