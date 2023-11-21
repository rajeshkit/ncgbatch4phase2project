package com.ticket_booking.repository;
import com.ticket_booking.entity.Flight;
import com.ticket_booking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    Flight findById(int flightNo);

    boolean existsBy();

    List<Flight> findAllByAirline_airlineId(int airlineId);


    List<Flight> findAllBySourceAndDestinationAndDepartureDateOrderByDepartureTime(Location source, Location destination, LocalDate date);
}
