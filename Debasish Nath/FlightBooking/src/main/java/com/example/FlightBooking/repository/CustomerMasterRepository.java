package com.example.FlightBooking.repository;


import com.example.FlightBooking.entity.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {
}


