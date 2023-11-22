package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRep extends JpaRepository<Customer,Long> {
    Optional<Customer> findByEmail(String email);

}