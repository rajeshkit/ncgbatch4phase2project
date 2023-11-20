package com.example.atrs.service;

import com.example.atrs.entity.AirlineMaster;
import com.example.atrs.repository.AirlineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImp implements AirlineService {
    private final AirlineRepository airlineRepository;

    public AirlineServiceImp(AirlineRepository airlineRepository){
        this.airlineRepository=airlineRepository;
    }
    private static final Logger logger = LoggerFactory.getLogger(AirlineServiceImp.class);

    @Override
    public void registerAirline(AirlineMaster airlineMaster) {
        logger.info("Saving airline master");
        airlineRepository.save(airlineMaster);
        logger.info("Airline Registered");
    }
    public List<AirlineMaster> getAllAirline(){
        logger.info("Getting all airline");
        return airlineRepository.findAll();
    }


}
