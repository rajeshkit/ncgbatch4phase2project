package com.ats.service;

import com.ats.entity.Location;

import java.util.List;

public interface LocationService {
    String locationRegister(Location location);

    List<Location> getAllLocations();
}
