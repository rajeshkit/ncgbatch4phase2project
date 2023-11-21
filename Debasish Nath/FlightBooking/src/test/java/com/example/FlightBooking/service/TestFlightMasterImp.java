package com.example.FlightBooking.service;

import com.example.FlightBooking.entity.FlightMaster;
import com.example.FlightBooking.exception.FlightIdNotFoundException;
import com.example.FlightBooking.exception.FlightSrcDestNotFoundException;
import com.example.FlightBooking.repository.FlightMasterRepository;
import com.example.FlightBooking.serviceImp.FlightMasterImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 class TestFlightMasterImp {
    @Mock
    private FlightMasterRepository flightMasterRepository;
    @InjectMocks
    private FlightMasterImp flightMasterImp;
    private FlightMaster flightMaster;

    @BeforeAll
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        flightMaster = new FlightMaster();
        flightMaster.setFlightId("F1000");
        flightMaster.setFare(1000D);
        flightMaster.setAvailableSeats(100);

        Mockito.when(flightMasterRepository.save(flightMaster)).thenReturn(flightMaster);
        List<Object[]> flights = new ArrayList<>();
        flights.add(new Object[]{flightMaster});
        Mockito.when(flightMasterRepository.getFlightMasterByflightId(Mockito.anyString())).thenReturn(flights);

        Mockito.when(flightMasterRepository.findFlightsBySourceAndDestination(Mockito.anyString(),Mockito.anyString())).thenReturn(flights);
    }



    @Test
    void testGetFlightMasterByFlightId() throws FlightIdNotFoundException {
        Assertions.assertNotNull(flightMasterImp.getFlightById("1001"));
    }
    @Test
     void testGetFlightBySourceAndDestination() throws FlightSrcDestNotFoundException{
        Assertions.assertNotNull(flightMasterImp.getFlightBySourceAndDestination("Bengaluru","Chennai"));
    }
}
