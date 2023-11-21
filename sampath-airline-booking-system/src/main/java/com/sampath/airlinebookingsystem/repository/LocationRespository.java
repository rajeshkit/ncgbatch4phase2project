package com.sampath.airlinebookingsystem.repository;

import com.sampath.airlinebookingsystem.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRespository extends JpaRepository<Location,Integer> {
}
