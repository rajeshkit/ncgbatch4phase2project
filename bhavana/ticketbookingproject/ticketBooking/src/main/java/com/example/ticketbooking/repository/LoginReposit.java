package com.example.ticketbooking.repository;

import com.example.ticketbooking.entity.Customer;
import com.example.ticketbooking.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginReposit extends JpaRepository<Customer, Long> {
    Optional<Login> findByEmail(String email);
}
