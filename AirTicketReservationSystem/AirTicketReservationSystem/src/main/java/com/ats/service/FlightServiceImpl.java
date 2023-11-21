package com.ats.service;

import com.ats.entity.CurrentAdminSession;
import com.ats.entity.Flight;
import com.ats.entity.Route;
import com.ats.exception.AdminException;
import com.ats.exception.FlightException;
import com.ats.repository.ICurrentAdminSessionRepository;
import com.ats.repository.IFlightRepository;
import com.ats.repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class FlightServiceImpl implements IFlightService{
    private final IFlightRepository flightRepository;
    private final IRouteRepository routeRepo;
    private final ICurrentAdminSessionRepository currAdminRepo;

    @Autowired
    public FlightServiceImpl(
            IFlightRepository flightRepository,
            IRouteRepository routeRepo,
            ICurrentAdminSessionRepository currAdminRepo) {
        this.flightRepository = flightRepository;
        this.routeRepo = routeRepo;
        this.currAdminRepo = currAdminRepo;
    }
    private static final String INVALID_KEY_MESSAGE = "Key is not valid! Please provide a valid key.";

    //admin access methods
    @Override
    public Flight addFlight(Flight flight, String key) throws FlightException , AdminException {
//        CurrentAdminSession admin = currAdminRepo.findByaid(key);
//        if(admin==null) throw new AdminException(INVALID_KEY_MESSAGE);

        //finding and checking route

        Route route = new Route(flight.getRouteFrom(),flight.getRouteTo());
        if(route==null) throw new FlightException("Route is not valid");


        //adding route for this new bus
        flight.setRoute(route);

        //adding this new bus to the route
        route.getFlightList().add(flight);

        //saving bus
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flight, String key) throws FlightException , AdminException{
        CurrentAdminSession admin = currAdminRepo.findByaid(key);
        if(admin==null){
            throw new AdminException(INVALID_KEY_MESSAGE);
        }
        Optional<Flight> flight1 = flightRepository.findById(flight.getFlightId());
        if(!flight1.isPresent()){
            throw new FlightException("Bus doesn't exist with busId: "+ flight.getFlightId());
        }


        Route route = routeRepo.findByRouteFromAndRouteTo(flight.getRouteFrom(),flight.getRouteTo()); //finding and checking route => pending

        if(route == null){
            Route route1 = new Route(flight.getRouteFrom(),flight.getRouteTo());
            routeRepo.save(route1);
            flight.setRoute(route1);
            return flightRepository.save(flight);
        }
        routeRepo.save(route);
        flight.setRoute(route);
        return flightRepository.save(flight);
    }

    @Override
    public Flight deleteFlight(Integer flightId, String key) throws FlightException, AdminException {
        CurrentAdminSession admin = currAdminRepo.findByaid(key);
        if(admin==null){
            throw new AdminException(INVALID_KEY_MESSAGE);
        }

        Optional<Flight> flight = flightRepository.findById(flightId);

        if(flight.isPresent()){
            Flight existingFlight = flight.get();
            //checking if current date is before journey date it means bus scheduled so can't delete / or seats are reserved or not
            if(LocalDate.now().isBefore(existingFlight.getFlightJourneyDate()) && !Objects.equals(existingFlight.getAvailableSeats(), existingFlight.getSeats())){
                throw new FlightException("Can't delete scheduled and reserved bus.");
            }

            flightRepository.delete(existingFlight);
            return existingFlight;

        } else throw  new FlightException("flight not found with flightId: "+flightId);

    }


    //admin + user access methods
    @Override
    public List<Flight> viewAllFlights() throws FlightException {
        List<Flight> flightList = flightRepository.findAll();
        if(flightList.isEmpty()){
            throw new FlightException("No flight found at this moment. Try again later!");
        }
        return flightList;
    }

    @Override
    public Flight viewFlight(Integer flightId) throws FlightException {
        Optional<Flight> existingFlight = flightRepository.findById(flightId);
        if(!existingFlight.isPresent()){
            throw new FlightException("No flight exist with this busId: "+ flightId);
        }
        return existingFlight.get();
    }

    @Override
    public List<Flight> viewFlightByFlightType(String flightType) throws FlightException {
        List<Flight> flightListType = flightRepository.findByFlightType(flightType);
        if(flightListType.isEmpty()){
            throw new FlightException("There are no flights with flight type: "+ flightType);
        }
        return flightListType;
    }
}
