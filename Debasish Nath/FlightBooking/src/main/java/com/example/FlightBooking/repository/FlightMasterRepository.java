package com.example.FlightBooking.repository;

import com.example.FlightBooking.entity.FlightMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightMasterRepository extends JpaRepository<FlightMaster,String> {

    @Query("SELECT flight.flightId AS flightId, flight.availableSeats AS availableSeats, " +
            "flight.departureDate AS departDate, flight.departureTime AS departTime, " +
            "flight.fare AS fare, flight.totalSeats AS totalSeats, airline.airlineName AS airlineName, " +
            "dl.locationName AS destinationLocation," +
            " sl.locationName AS sourceLocation " +
            "FROM FlightMaster flight " +
            "INNER JOIN flight.airlineId airline " +
            "INNER JOIN flight.destinationId dl " +
            "INNER JOIN flight.sourceId sl " +
            "WHERE flight.flightId = :flightNumber")
    public List<Object[]> getFlightMasterByflightId(@Param("flightNumber") String flightNumber);


    @Query("SELECT flight.flightId AS flightId, flight.availableSeats AS availableSeats, " +
            "flight.departureDate AS departDate, flight.departureTime AS departTime, " +
            "flight.fare AS fare, flight.totalSeats AS totalSeats, airline.airlineName AS airlineName, " +
            "dl.locationName AS destinationLocation, sl.locationName AS sourceLocation " +
            "FROM FlightMaster flight " +
            "INNER JOIN flight.airlineId airline " +
            "INNER JOIN flight.destinationId dl " +
            "INNER JOIN flight.sourceId sl " +
            "WHERE dl.locationName = :destination AND sl.locationName = :source")
    List<Object[]> findFlightsBySourceAndDestination(@Param("source") String source, @Param("destination") String destination);


    @Query("SELECT flight.flightId AS flightId, flight.availableSeats AS availableSeats, " +
            "flight.departureDate AS departDate, flight.departureTime AS departTime, " +
            "flight.fare AS fare, flight.totalSeats AS totalSeats, airline.airlineName AS airlineName, " +
            "dl.locationName AS destinationLocation," +
            " sl.locationName AS sourceLocation " +
            "FROM FlightMaster flight " +
            "INNER JOIN flight.airlineId airline " +
            "INNER JOIN flight.destinationId dl " +
            "INNER JOIN flight.sourceId sl ")
    public List<Object[]> getAllFlights();
}
