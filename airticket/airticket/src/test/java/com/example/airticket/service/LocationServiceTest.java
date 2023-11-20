package com.example.airticket.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import java.util.List;

import com.example.airticket.entity.Location;
import com.example.airticket.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

 class LocationServiceTest {

    @Mock

    private LocationRepository locationRepository;

    @InjectMocks

    private LocationService locationService;

    @BeforeEach

    public void setUp() {

        MockitoAnnotations.openMocks(this);

    }

    @Test

     void testGetAllLocations() {

        Location location1 = new Location(1, "City1");
        Location location2 = new Location(2, "City2");
        List<Location> locations = Arrays.asList(location1, location2);
        when(locationRepository.findAll()).thenReturn(locations);
        List<Location> result = locationService.getLocationDetails();
        assertEquals(locations.size(), result.size());
        assertEquals(location1, result.get(0));
        assertEquals(location2, result.get(1));
        verify(locationRepository, times(1)).findAll();
    }

    @Test

     void testGetAllLocationsWithEmptyList() {
        when(locationRepository.findAll()).thenReturn(Arrays.asList());

        List<Location> result = locationService.getLocationDetails();
        assertTrue(result.isEmpty());
         verify(locationRepository, times(1)).findAll();
    }
    @Test
     void testGetAllLocationsWithException() {
        when(locationRepository.findAll()).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(RuntimeException.class, () -> locationService.getLocationDetails());
        verify(locationRepository, times(1)).findAll();

    }

}

