package com.example.atrs.repository;

import com.example.atrs.entity.LocationMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationMaster,Integer> {


}
