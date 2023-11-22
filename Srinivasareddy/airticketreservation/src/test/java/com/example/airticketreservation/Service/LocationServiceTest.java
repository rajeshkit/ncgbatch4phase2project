package com.example.airticketreservation.Service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Arrays;

import java.util.List;

import com.example.airticketreservation.entity.Location;
import com.example.airticketreservation.repository.LocationRep;
import com.example.airticketreservation.service.LocationService;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

class LocationServiceTest {

    @Mock
    private LocationRep locationRep;

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
        when(locationRep.findAll()).thenReturn(locations);
        List<Location> result = locationService.getLocations();
        assertEquals(locations.size(), result.size());
        assertEquals(location1, result.get(0));
        assertEquals(location2, result.get(1));
        verify(locationRep, times(1)).findAll();
    }

    @Test
    void testGetAllLocationsWithEmptyList() {
        when(locationRep.findAll()).thenReturn(List.of());
        List<Location> result = locationService.getLocations();
        assertTrue(result.isEmpty());
        verify(locationRep, times(1)).findAll();
    }

    @Test
    void testGetAllLocationsWithException() {
        when(locationRep.findAll()).thenThrow(new RuntimeException("Test Exception"));
        assertThrows(RuntimeException.class, () -> locationService.getLocations());
        verify(locationRep, times(1)).findAll();
    }

}
