package com.example.atrs.repository;

import com.example.atrs.entity.FlightMaster;

import com.example.atrs.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface FlightRepository extends JpaRepository<FlightMaster,Integer> {
     List<Object> findBySourceIdAndDestinationIdAndDprDate(LocationMaster sourceId, LocationMaster destinationId, Date dprDate);

}
