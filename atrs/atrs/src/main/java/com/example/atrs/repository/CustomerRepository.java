package com.example.atrs.repository;

import com.example.atrs.entity.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerMaster,Integer>{
Optional<CustomerMaster> findByEmailAndPassword(String email, String password);
boolean existsByEmail(String email);
}