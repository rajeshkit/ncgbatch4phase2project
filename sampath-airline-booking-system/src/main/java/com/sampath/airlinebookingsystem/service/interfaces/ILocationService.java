package com.sampath.airlinebookingsystem.service.interfaces;

import com.sampath.airlinebookingsystem.dtos.LocationDto;

import java.util.List;

public interface ILocationService {
    public LocationDto createLocation(LocationDto locationDto);
    public LocationDto updateLocation(LocationDto locationDto, Integer locationId);
    public void deleteLocation(Integer locationId);
    public LocationDto getLocation(Integer locationId);
    public List<LocationDto> getAllLocations();
}
