package com.example.air_ticket_reservation_system.repository;


import com.example.air_ticket_reservation_system.entity.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerMaster,String> {
}
