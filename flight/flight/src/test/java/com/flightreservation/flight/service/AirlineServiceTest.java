package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Airline;
import com.flightreservation.flight.repository.IAirlineRepo;
import com.flightreservation.flight.service.AirlineServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AirlineServiceTest {

    @Mock
    private IAirlineRepo airlineRepo;

    @InjectMocks
    private AirlineServiceImpl airlineService;

    @Test
    public void testGetAllAirlines() {
        List<Airline> airlines = Arrays.asList(
                new Airline(),
                new Airline()

        );
        when(airlineRepo.findAll()).thenReturn(airlines);


        List<Airline> result = airlineService.getAllAirlines();


        assertEquals(2, result.size()); }

    @Test
    public void testGetLocation() {
        // Mocking the behavior of airlineRepo.findById() method
        Airline airline = new Airline();
        when(airlineRepo.findById(1)).thenReturn(Optional.of(airline));

        // Calling the service method
        Optional<Airline> result = airlineService.getLocation(1);

        // Asserting the result
        assertEquals(airline, result.orElse(null)); // Modify assertions based on your implementation
    }

    @Test
    public void testRegisterAirline() {

        Airline newAirline = new Airline();

        when(airlineRepo.save(newAirline)).thenReturn(newAirline);

        // Calling the service method
        Airline result = airlineService.registerAirline(newAirline);

        // Asserting the result
        assertEquals(newAirline, result); // Modify assertions based on your implementation
    }
}
