package com.example.ticketbooking.repository;

import com.example.ticketbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingReposit extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomerId(Long customerId);
}
