package com.example.atrs.service;

import com.example.atrs.entity.LocationMaster;
import com.example.atrs.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {
    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImp.class);
    private final LocationRepository locationRepository;
    public LocationServiceImp(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }
    public LocationMaster registerLocation(LocationMaster locationMaster){
        logger.info("location Saved Successfully");
        return locationRepository.save(locationMaster);
    }
    public List<LocationMaster> getAllLocation(){
        logger.info("Fetching all location");
        return locationRepository.findAll();
    }
}
