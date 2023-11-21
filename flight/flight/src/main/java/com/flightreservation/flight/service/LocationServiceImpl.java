package com.flightreservation.flight.service;
import com.flightreservation.flight.entity.Location;
import com.flightreservation.flight.exception.LocationNotFoundException;
import com.flightreservation.flight.repository.ILocationRepo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LocationServiceImpl implements ILocationService{

    public final ILocationRepo locationRepo;

    Location l=new Location();
@Autowired
    public LocationServiceImpl(ILocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public String findLocation() {
        locationRepo.toString();
        return l.getLocationName();
    }

    @SneakyThrows
    @Override
    public List<Location> getAllLocations() {
    if(locationRepo==null)
    {
        String message="no locations found";
        throw new LocationNotFoundException(message);
    }

        return locationRepo.findAll();
    }
}
