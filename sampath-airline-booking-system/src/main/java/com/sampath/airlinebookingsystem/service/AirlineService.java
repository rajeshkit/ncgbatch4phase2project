package com.sampath.airlinebookingsystem.service;

import com.sampath.airlinebookingsystem.dtos.AirlineDto;
import com.sampath.airlinebookingsystem.entity.Airline;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.AirlineRepository;
import com.sampath.airlinebookingsystem.service.interfaces.IAirlineService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineService implements IAirlineService {


    private final AirlineRepository airlineRepository;

    private final ModelMapper modelMapper =new ModelMapper();

    Logger logger = LoggerFactory.getLogger(AirlineService.class);

    @Autowired
    public AirlineService(AirlineRepository airlineRepository, ModelMapper modelMapper) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public AirlineDto createAirline(AirlineDto airlineDto) {
        Airline airline = this.modelMapper.map(airlineDto,Airline.class);
        logger.debug("Airline name: {}", airline.getAirlineName());
        Airline savedAirline = this.airlineRepository.save(airline);
        return this.modelMapper.map(savedAirline,AirlineDto.class);
    }

    @Override
    public AirlineDto updateAirline(AirlineDto airlineDto, Integer airlineId) {
        Airline airline =
                this.airlineRepository.findById(airlineId).orElseThrow(()-> new ResourceNotFoundException("Airline","Airline ID",airlineId));
        airline.setAirlineName(airlineDto.getAirlineName());
        airline.setDop(airlineDto.getDop());
        Airline updatedAirline = this.airlineRepository.save(airline);
        return this.modelMapper.map(updatedAirline,AirlineDto.class);
    }

    @Override
    public void deleteAirline(Integer airlineId) {
        Airline airline =
                this.airlineRepository.findById(airlineId).orElseThrow(()-> {
                    logger.error("AIRLINE ID NOT FOUND");
                  return   new ResourceNotFoundException(
                            "Airline service class", "Airline id", airlineId);
                });
        this.airlineRepository.delete(airline);
    }

    @Override
    public AirlineDto getAirline(Integer airlineId) {
        Airline airline =
                this.airlineRepository.findById(airlineId).orElseThrow(()-> {
                    logger.error("AIRLINE ID NOT FOUND");
                    return new ResourceNotFoundException(
                            "Airline class", "Airline number", airlineId);
                });
        return this.modelMapper.map(airline,AirlineDto.class);
    }

    @Override
    public List<AirlineDto> getAllAirlines() {
        List<Airline> airlines = this.airlineRepository.findAll();
        return airlines.stream().map(airline->this.modelMapper.map(airline,
                        AirlineDto.class)).collect(Collectors.toList());
    }
}
