package com.sampath.airlinebookingsystem.service.interfaces;

import com.sampath.airlinebookingsystem.dtos.AirlineDto;

import java.util.List;

public interface IAirlineService {
    public AirlineDto createAirline(AirlineDto airlineDto);
    public AirlineDto updateAirline(AirlineDto airlineDto, Integer airlineId);
    public void deleteAirline(Integer airlineId);
    public AirlineDto getAirline(Integer airlineId);
    public List<AirlineDto> getAllAirlines();
}
