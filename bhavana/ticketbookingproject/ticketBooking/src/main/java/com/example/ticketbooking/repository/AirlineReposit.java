package com.example.ticketbooking.repository;

import com.example.ticketbooking.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineReposit extends JpaRepository<Airline,Integer>
{
    Optional<Airline> findByName(String name);
}
