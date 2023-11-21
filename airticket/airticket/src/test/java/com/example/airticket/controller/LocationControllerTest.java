package com.example.airticket.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.Arrays;
import java.util.List;
import com.example.airticket.entity.Location;
import com.example.airticket.service.LocationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

 class LocationControllerTest {
    @Mock
    private LocationServiceImpl locationService;
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
        when(locationService.getLocationDetails()).thenReturn(locations);
        ResponseEntity<List<Location>> response = locationController.getLocationDetails();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(locations, response.getBody());
    }
    @Test
     void testGetAllLocationsWhenNoLocationsExist() {

        when(locationService.getLocationDetails()).thenReturn(List.of());


        ResponseEntity<List<Location>> response = locationController.getLocationDetails();


        assertEquals(204, response.getStatusCodeValue()); // No Content

        assertNull(response.getBody());

    }

    @Test

     void testGetAllLocationsWithException() {

        when(locationService.getLocationDetails()).thenThrow(new RuntimeException("Test Exception"));

        assertThrows(RuntimeException.class, () -> locationController.getLocationDetails());

    }

}
