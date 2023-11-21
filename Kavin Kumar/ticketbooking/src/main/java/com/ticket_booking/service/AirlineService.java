package com.ticket_booking.service;
import com.ticket_booking.extras.Result;
import com.ticket_booking.entity.Airline;
import com.ticket_booking.entity.Flight;
import com.ticket_booking.entity.Location;
import com.ticket_booking.exception.NotLoggedInException;
import com.ticket_booking.exception.UnexpectedErrorException;
import com.ticket_booking.exception.ValueAlreadyExistsException;
import com.ticket_booking.exception.ValueNotFoundException;
import com.ticket_booking.repository.AirlineRepository;
import com.ticket_booking.repository.FlightRepository;
import com.ticket_booking.repository.LocationRepository;
import com.ticket_booking.extras.LoggedInId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService implements AirlineServiceInterface{
    private final AirlineRepository airlineRepository;
    private final LocationRepository locationRepository;
    private final FlightRepository flightRepository;
    private final LoggedInId loggedInId;

    @Autowired
    public AirlineService(
            AirlineRepository airlineRepository,
            LocationRepository locationRepository,
            FlightRepository flightRepository,
            LoggedInId loggedInId
    ) {
        this.airlineRepository = airlineRepository;
        this.locationRepository = locationRepository;
        this.flightRepository = flightRepository;
        this.loggedInId = loggedInId;
    }

    Logger logger= LoggerFactory.getLogger(AirlineService.class);
    String message;
    @Override
    public ResponseEntity<Object> register(Airline airline) {

        if(airlineRepository.existsByAirlineId(airline.getAirlineId()))
        {
            message="Airline id already present";
            throw new ValueAlreadyExistsException(message);
        }
        if(airlineRepository.existsByAirlineName(airline.getAirlineName()))
        {
            message="Airline Name already present";
            throw new ValueAlreadyExistsException(message);
        }
        airlineRepository.save(airline);

        message="Airline registered successfully! Airline Id:"+airline.getAirlineId();
        logger.info(message);
        Result result=new Result(true,message);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Object> login(Airline airline) {
        int airlineId= airline.getAirlineId();
        String password= airline.getPassword();

        if(!airlineRepository.existsByAirlineId(airlineId))
        {
            message="Airline Id not registered";
            throw new ValueNotFoundException(message);
        }

        if(airlineRepository.existsByAirlineIdAndPassword(airlineId,password))
        {
            message="Airline Login Success!";
            logger.info(message);
            loggedInId.setAirlineId(airline.getAirlineId());
            Result result=new Result(true,message);
            return ResponseEntity.ok(result);
        }
        message="Entered wrong Airline password";
        logger.error(message);
        Result result=new Result(message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);    }

    @Override
    public ResponseEntity<Object> addLocation(Location location) {
        if(loggedInId.getAirlineId()==0){
            message="Sorry you have login first to add location";
            throw new NotLoggedInException(message);

        }
        if(locationRepository.existsByLocationId(location.getLocationId())){
            message="Unexpected error please try again";
            throw new UnexpectedErrorException(message);
           }
        if(locationRepository.existsByLocationName(location.getLocationName())){
            message=location.getLocationName()+" location already present";
            throw new ValueNotFoundException(message);
           }
        locationRepository.save(location);
        message="New Location added success!";
        logger.info(message);
        Result result=new Result(true,message);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Object> addFlight(Flight flight) {
        if(loggedInId.getAirlineId()==0){
            message="Sorry you have login first to add flight";
            throw new NotLoggedInException(message);

        }
        int flightNo=flight.getFlightNo();
        int sourceId=flight.getSourceId();
        int destinationId=flight.getDestinationId();
        if(flightRepository.existsById(flightNo))
        {
            message= flightNo+" flight number already present";
            throw new ValueAlreadyExistsException(message);
        }

        if(!locationRepository.existsByLocationId(sourceId))
        {
            message="Source location not found";
            throw new ValueNotFoundException(message);
        }
        if(!locationRepository.existsByLocationId(destinationId))
        {
            message="destination location not present";
            throw new ValueNotFoundException(message);
        }
        if(sourceId==destinationId){
            message="Source and destination cannot be same";
            throw new UnexpectedErrorException(message);
        }
        Airline airline=airlineRepository.findAirlineByAirlineId(loggedInId.getAirlineId());
        Location source=locationRepository.findByLocationId(sourceId);
        Location destination=locationRepository.findByLocationId(destinationId);
        flight.setAirline(airline);
        flight.setSource(source);
        flight.setDestination(destination);
        flightRepository.save(flight);
        message="new flight add success!";
        logger.info(message);
        Result result=new Result(true,message);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Object> getAllLocations() {
        if(!locationRepository.existsBy()){
            message="No locations found";
            throw new ValueNotFoundException(message);
        }
        message="fetched all locations";
        logger.info(message);
        return ResponseEntity.ok(locationRepository.findAll());
    }

    @Override
    public ResponseEntity<Object> getLocation(int locationId) {
        if(!locationRepository.existsById(locationId)) {
            message =locationId+ " Location id not present";
            throw new ValueNotFoundException(message);
        }
        logger.info("Fetched location with id: {}",locationId);
        return ResponseEntity.ok(locationRepository.findByLocationId(locationId));
    }

    @Override
    public ResponseEntity<Object> getLocation(String location) {
        if(!locationRepository.existsByLocationName(location)) {
            message = location +" Location not present";
            throw new ValueNotFoundException(message);
        }
        logger.info("fetched Location: {}",location);
        return ResponseEntity.ok(locationRepository.findByLocationName(location));
    }

    @Override
    public ResponseEntity<Object> getFlights() {
        if(loggedInId.getAirlineId()==0){
            message="Sorry you have login first to see flights";
            throw new NotLoggedInException(message);
        }

        List<Flight> flightList=flightRepository.findAllByAirline_airlineId(loggedInId.getAirlineId());
        if(flightList.isEmpty()){
            message="no flights found!";logger.error(message);
            throw new ValueNotFoundException(message);
        }
        message="fetched all flights of your airline id"+loggedInId.getAirlineId();
        logger.info(message);
        return new ResponseEntity<>(flightList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> logout() {
        loggedInId.setAirlineId(0);
        Result result=new Result(true,"Logout success");
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
