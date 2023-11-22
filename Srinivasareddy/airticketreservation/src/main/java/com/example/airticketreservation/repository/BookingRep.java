package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRep extends JpaRepository<Booking,Long> {
    List<Booking> findByCustomerId(Long customerId);
}