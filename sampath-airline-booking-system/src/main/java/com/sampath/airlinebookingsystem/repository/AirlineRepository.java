package com.sampath.airlinebookingsystem.repository;

import com.sampath.airlinebookingsystem.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline,Integer> {
}
