package com.flightreservation.flight.repository;

import com.flightreservation.flight.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistrationRepo extends JpaRepository<CustomerRegistration,Integer> {
}
