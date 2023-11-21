package com.ticket_booking.repository;

import com.ticket_booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookingInfoRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findAllBookingInfoByCustomer_Id(int customerId);
    Booking findById(int customerId);
}
