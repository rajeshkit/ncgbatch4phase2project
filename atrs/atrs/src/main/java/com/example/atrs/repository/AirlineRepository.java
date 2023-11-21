package com.example.atrs.repository;

import com.example.atrs.entity.AirlineMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<AirlineMaster,Integer> {
}
