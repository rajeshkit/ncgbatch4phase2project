package com.example.airticket.service;

import com.example.airticket.entity.Airline;
import com.example.airticket.repository.AirlineRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AirlineServiceTest {

    @Mock
    private AirlineRepository airlineRepository;

    @InjectMocks
    private AirlineService airlineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAirlinesDetailsShouldReturnListOfAirlines() {
        // Arrange
        List<Airline> mockAirlines = Arrays.asList(
                new Airline(1L, "Airline1"),
                new Airline(2L, "Airline2")
        );
        when(airlineRepository.findAll()).thenReturn(mockAirlines);

        List<Airline> result = airlineService.getAirlinesDetails();

        assertEquals(mockAirlines.size(), result.size());
        assertEquals(mockAirlines, result);
    }

    @Test
    void getAirlinesDetailsShouldReturnEmptyList() {
        List<Airline> emptyList = Arrays.asList();

        when(airlineRepository.findAll()).thenReturn(emptyList);

        List<Airline> result = airlineService.getAirlinesDetails();

        assertEquals(emptyList.size(), result.size());
        assertEquals(emptyList, result);
    }
}
