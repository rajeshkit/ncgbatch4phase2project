package com.example.atrs.controller;

import com.example.atrs.entity.LocationMaster;
import com.example.atrs.service.LocationServiceImp;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location-api")
public class LocationController {
    private final LocationServiceImp locationServiceImp;

    public LocationController(LocationServiceImp locationServiceImp){
        this.locationServiceImp=locationServiceImp;
    }
    @PostMapping(path="/locationRegister")
    public LocationMaster locReg(@RequestBody @Valid LocationMaster locationMaster){
        return locationServiceImp.registerLocation(locationMaster);
    }
    @GetMapping(path = "/locationById")
    public List<LocationMaster> getLocation(){
        return locationServiceImp.getAllLocation();
    }
}
