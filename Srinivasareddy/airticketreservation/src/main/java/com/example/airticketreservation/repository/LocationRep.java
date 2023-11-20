package com.example.airticketreservation.repository;

import com.example.airticketreservation.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRep extends JpaRepository<Location,Long> {
}
