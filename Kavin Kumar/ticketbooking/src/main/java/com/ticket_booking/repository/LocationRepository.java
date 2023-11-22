package com.ticket_booking.repository;

import com.ticket_booking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
    boolean existsByLocationId(int locationId);
    Location findByLocationId(int locationId);
    boolean existsByLocationName(String location);
    boolean existsBy();

    Location findByLocationName(String location);
}
