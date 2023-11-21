package com.example.airticket.repository;

import com.example.airticket.entity.Customer;
import com.example.airticket.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Customer,Long> {
    Optional<Login> findByEmail(String email);
}
