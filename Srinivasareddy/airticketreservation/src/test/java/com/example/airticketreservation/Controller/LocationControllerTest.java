package com.example.airticketreservation.Controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;

import com.example.airticketreservation.controller.LocationController;
import com.example.airticketreservation.entity.Location;
import com.example.airticketreservation.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class LocationControllerTest {
    @Mock
    private LocationService locationService;
    @InjectMocks
    private LocationController locationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllLocationsWhenLocationsExist() {
        Location location1 = new Location(1, "City1");
        Location location2 = new Location(2, "City2");
        List<Location> locations = Arrays.asList(location1, location2);
        when(locationService.getLocations()).thenReturn(locations);
        ResponseEntity<List<Location>> response = locationController.getLocations();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(locations, response.getBody());
    }
    @Test
    void testGetAllLocationsWhenNoLocationsExist() {
        when(locationService.getLocations()).thenReturn(List.of());
        ResponseEntity<List<Location>> response = locationController.getLocations();
        assertEquals(204, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void testGetAllLocationsWithException() {
        when(locationService.getLocations()).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(RuntimeException.class, () -> locationController.getLocations());
    }

}