package com.example.atrs.service;

import com.example.atrs.entity.AirlineMaster;

import java.util.List;


public interface AirlineService {
     void registerAirline(AirlineMaster airlineMaster);
     List<AirlineMaster> getAllAirline();

}
