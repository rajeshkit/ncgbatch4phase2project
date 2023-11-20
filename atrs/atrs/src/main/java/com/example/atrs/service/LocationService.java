package com.example.atrs.service;

import com.example.atrs.entity.LocationMaster;

import java.util.List;

public interface LocationService {
     LocationMaster registerLocation(LocationMaster locationMaster);
     List<LocationMaster> getAllLocation();
}
