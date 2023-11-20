package com.example.atrs.dto;

import com.example.atrs.entity.LocationMaster;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightFetch {
    private LocationMaster sourceId;
    private LocationMaster destinationId;
    private Date dprDate;
}
