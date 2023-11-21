package com.example.airticket.controller;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.example.airticket.entity.Airline;
import com.example.airticket.service.AirlineServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
class AirlineControllerTest {
    @Mock
    private AirlineServiceImp airlineService;
    @InjectMocks
    private AirlineController airlineController;
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
        when(airlineService.getAirlinesDetails()).thenReturn(mockAirlines);

        ResponseEntity<List<Airline>> responseEntity = airlineController.getAirlinesDetails();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(mockAirlines, responseEntity.getBody());
    }

    @Test
    void getAirlinesDetailsShouldReturnNoContentForEmptyList() {
        // Arrange
        when(airlineService.getAirlinesDetails()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<Airline>> response = airlineController.getAirlinesDetails();

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(Collections.emptyList(), response.getBody());
    }
}
