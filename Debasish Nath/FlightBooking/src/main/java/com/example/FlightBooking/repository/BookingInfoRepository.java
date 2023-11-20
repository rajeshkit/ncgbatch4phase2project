package com.example.FlightBooking.repository;


import com.example.FlightBooking.entity.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingInfoRepository extends JpaRepository<BookingInfo, Long> {
    @Query("SELECT flight.flightId AS flightId, flight.availableSeats AS availableSeats, " +
            "flight.departureDate AS departDate, " +
            "flight.fare AS fare, bookinginfo.bookingId AS bookingId, bookinginfo.bookingDate AS bookingDate, " +
            "bookinginfo.seatBook AS seatBook " +
            "FROM BookingInfo bookinginfo " +
            "INNER JOIN bookinginfo.flightId flight " +
            "WHERE bookinginfo.bookingId = :bookId")
    public List<Object[]> getBookingDetailsByBookId(@Param("bookId") Long bookId);
}


