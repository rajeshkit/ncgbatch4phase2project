package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRep extends JpaRepository<Customer,Long> {
}
