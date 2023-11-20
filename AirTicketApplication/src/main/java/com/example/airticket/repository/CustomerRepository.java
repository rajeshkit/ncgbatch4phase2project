package com.example.airticket.repository;

import com.example.airticket.entity.CustomerRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerRegistration,Integer> {
    Optional<CustomerRegistration> findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);

    CustomerRegistration findById(int customerNumber);
}
