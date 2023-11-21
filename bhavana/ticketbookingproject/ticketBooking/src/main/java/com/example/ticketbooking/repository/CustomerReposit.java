package com.example.ticketbooking.repository;

import com.example.ticketbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerReposit extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
