package com.example.ticketbooking.repository;

import com.example.ticketbooking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationReposit extends JpaRepository<Location, Long> {
}
