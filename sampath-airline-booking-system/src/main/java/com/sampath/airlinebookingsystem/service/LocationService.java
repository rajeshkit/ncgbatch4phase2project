package com.sampath.airlinebookingsystem.service;

import com.sampath.airlinebookingsystem.dtos.LocationDto;
import com.sampath.airlinebookingsystem.entity.Location;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.LocationRespository;
import com.sampath.airlinebookingsystem.service.interfaces.ILocationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService implements ILocationService {
    private final LocationRespository locationRespository;
    private final ModelMapper modelMapper;

    @Autowired
    public LocationService(LocationRespository locationRespository, ModelMapper modelMapper) {
        this.locationRespository = locationRespository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LocationDto createLocation(LocationDto locationDto) {
        Location location = this.modelMapper.map(locationDto,Location.class);
        Location savedLocation = locationRespository.save(location);
        return this.modelMapper.map(savedLocation,LocationDto.class);
    }

    @Override
    public LocationDto updateLocation(LocationDto locationDto, Integer locationId) {
        Location location =
                this.locationRespository.findById(locationId).orElseThrow(()-> new ResourceNotFoundException(
                        "Location","Location ID",locationId));

        location.setLocationName(locationDto.getLocationName());
        Location updatedLocation = this.locationRespository.save(location);
        return this.modelMapper.map(updatedLocation,LocationDto.class);
    }

    @Override
    public void deleteLocation(Integer locationId) {
        Location location =
                this.locationRespository.findById(locationId).orElseThrow(()-> new ResourceNotFoundException(
                        "Location class","Location id",locationId));
        this.locationRespository.delete(location);
    }

    @Override
    public LocationDto getLocation(Integer locationId) {
        Location location =
                this.locationRespository.findById(locationId).orElseThrow(()-> new ResourceNotFoundException(
                        "Location","Location ID",locationId));
        return this.modelMapper.map(location,LocationDto.class);
    }

    @Override
    public List<LocationDto> getAllLocations() {
        List<Location> locations = this.locationRespository.findAll();
        return locations.stream().map(location->this.modelMapper.map(location,
                        LocationDto.class)).collect(Collectors.toList());
    }
}
