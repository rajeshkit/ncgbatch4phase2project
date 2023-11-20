package com.sampath.airlinebookingsystem.repository;

import com.sampath.airlinebookingsystem.entity.Flight;
import com.sampath.airlinebookingsystem.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FlightRespository extends JpaRepository<Flight,Integer> {

    public List<Flight> findBySrcAndDestAndDepartDate(Location src, Location dest, Date date);

}
