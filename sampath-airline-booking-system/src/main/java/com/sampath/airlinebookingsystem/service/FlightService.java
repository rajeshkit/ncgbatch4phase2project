package com.sampath.airlinebookingsystem.service;

import com.sampath.airlinebookingsystem.dtos.FlightDto;
import com.sampath.airlinebookingsystem.entity.Airline;
import com.sampath.airlinebookingsystem.entity.Flight;
import com.sampath.airlinebookingsystem.entity.Location;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.AirlineRepository;
import com.sampath.airlinebookingsystem.repository.FlightRespository;
import com.sampath.airlinebookingsystem.repository.LocationRespository;
import com.sampath.airlinebookingsystem.service.interfaces.IFlightService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements IFlightService {


    private final FlightRespository flightRespository;

    private final ModelMapper modelMapper;

    private final LocationRespository locationRespository;

    private final AirlineRepository airlineRepository;

    @Autowired
    public FlightService(FlightRespository flightRespository, ModelMapper modelMapper, LocationRespository locationRespository, AirlineRepository airlineRepository) {
        this.flightRespository = flightRespository;
        this.modelMapper = modelMapper;
        this.locationRespository = locationRespository;
        this.airlineRepository = airlineRepository;
    }


    @Override
    public FlightDto createFlight(FlightDto flightDto, Integer aId, Integer srcId, Integer destId) {

        Airline airline =
                this.airlineRepository.findById(aId).orElseThrow(()->new ResourceNotFoundException("airline","airline id",aId));
        Location sourceLocation =
                this.locationRespository.findById(srcId).orElseThrow(()->new ResourceNotFoundException("location","location Id",srcId));
        Location destinationLocation =
              this.locationRespository.findById(destId).orElseThrow(()->new ResourceNotFoundException(
                "location","location Id",destId));

        Flight flight = this.modelMapper.map(flightDto,Flight.class);
        flight.setAirlineId(airline);
        flight.setSrc(sourceLocation);
        flight.setDest(destinationLocation);

        Flight savedFlight = this.flightRespository.save(flight);
        return this.modelMapper.map(savedFlight,FlightDto.class);
    }

    @Override
    public FlightDto getFlight(int flightId) {
        Flight flight =
                this.flightRespository.findById(flightId).orElseThrow(()->new ResourceNotFoundException("Flight","Flight id",flightId));

        return this.modelMapper.map(flight,FlightDto.class);
    }

    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flights = this.flightRespository.findAll();
        return flights.stream().map(flight -> this.modelMapper.map(flight,
                FlightDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<FlightDto> searchFlight(Location sourceLocation, Location destLocation, Date date) {
        List<Flight> flights = this.flightRespository.findBySrcAndDestAndDepartDate(sourceLocation,
                destLocation,date);
        return flights.stream().map(flight -> this.modelMapper.map(flight,
                FlightDto.class)).collect(Collectors.toList());
    }
}
