package com.example.air_ticket_reservation_system.repository;

import com.example.air_ticket_reservation_system.entity.BookingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationRepository extends JpaRepository<BookingInfo,String> {
}
