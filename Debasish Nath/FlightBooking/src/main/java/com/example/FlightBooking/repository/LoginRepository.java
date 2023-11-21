package com.example.FlightBooking.repository;

import com.example.FlightBooking.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,String> {
    Login findByEmailAndPassword(String email,String password);

}
