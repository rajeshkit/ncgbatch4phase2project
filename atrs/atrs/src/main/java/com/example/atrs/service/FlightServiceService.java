package com.example.atrs.service;

import com.example.atrs.dto.FlightFetch;
import com.example.atrs.entity.FlightMaster;
import com.example.atrs.entity.LocationMaster;
import com.example.atrs.repository.FlightRepository;
import com.example.atrs.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceService implements FlightService {
    private static final Logger logger = LoggerFactory.getLogger(FlightServiceService.class);

    private final FlightRepository flightRepository;
    private final LocationRepository locationRepository;

    public FlightServiceService(FlightRepository flightRepository, LocationRepository locationRepository){
        this.flightRepository = flightRepository;
        this.locationRepository=locationRepository;
    }

    @Override
    public ResponseEntity<Object> registerFlight(FlightMaster flightMaster) {
       if(flightMaster==flightRepository.save(flightMaster)){
           logger.info("Flight registered");
           return ResponseEntity.status(HttpStatus.CREATED).body("Flight Registered");
       }
       logger.error("OOPS!...Flight not registered");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problem in Registering Flight");
    }
    public FlightMaster searchFlightById(int flightId){
        logger.info("Searching flight by id");
        Optional<FlightMaster> flightDet=flightRepository.findById(flightId);
        FlightMaster det=null;
        if(flightDet.isPresent()){
            det=flightDet.get();
        }else{
            logger.error("No such flights available");
        }
        return  det;
    }
    @Override
    public ResponseEntity<Object> searchFlight(FlightFetch flightFetch) {
        logger.info("Searching flight by source,destination,departure date");
        LocationMaster source=locationRepository.findById(flightFetch.getSourceId().getLocationId()).orElseThrow();
        LocationMaster destination=locationRepository.findById(flightFetch.getDestinationId().getLocationId()).orElseThrow();
        Date dpDate= flightFetch.getDprDate();
        int sId=source.getLocationId();
        int dId=destination.getLocationId();
        List<FlightMaster> flightLi=new ArrayList<>();
        List<FlightMaster> all=flightRepository.findAll();
        for(FlightMaster flightMas:all) {
            LocationMaster source1 = flightMas.getSourceId();
            LocationMaster destination1 = flightMas.getDestinationId();
            int s1 = source1.getLocationId();
            int s2 = destination1.getLocationId();
            Date d1 = flightMas.getDprDate();
            if (s1 == sId && s2 == dId && d1.toString().equals(dpDate.toString())) {
                flightLi.add(flightMas);
                return ResponseEntity.ok(flightLi);
            } else {
                logger.error("No flights available");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flights found");
            }
        }
        return null;
    }
   public List<Object> searchFlight1(LocationMaster sourceId, LocationMaster destinationId, Date dprDate) {
       return flightRepository.findBySourceIdAndDestinationIdAndDprDate(sourceId, destinationId, dprDate);
   }
   public List<FlightMaster> getAllFlight(){
        return flightRepository.findAll();
   }
}


