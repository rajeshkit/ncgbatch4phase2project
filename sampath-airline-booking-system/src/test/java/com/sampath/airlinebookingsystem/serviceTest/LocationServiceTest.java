package com.sampath.airlinebookingsystem.serviceTest;

import com.sampath.airlinebookingsystem.dtos.LocationDto;
import com.sampath.airlinebookingsystem.entity.Location;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.LocationRespository;
import com.sampath.airlinebookingsystem.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LocationServiceTest {

    @MockBean
    private LocationRespository locationRespository;

    private LocationService locationService;

    @BeforeEach
    void setUp() {
        ModelMapper modelMapper = new ModelMapper();
        locationService = new LocationService(locationRespository, modelMapper);
    }

    @Test
    void testCreateLocation() {
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationName("Hyderabad");

        Location location = new Location();
        location.setLocationName("Hyderabad");

        when(locationRespository.save(any(Location.class))).thenReturn(location);
        LocationDto result = locationService.createLocation(locationDto);
        assertNotNull(result);
        assertEquals("Hyderabad", result.getLocationName());
    }

    @Test
    void testUpdateLocation() {
        // Arrange
        Integer locationId = 1;
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationName("Chennai");

        Location existingLocation = new Location();
        existingLocation.setLocationId(locationId);
        existingLocation.setLocationName("Chennai");

        when(locationRespository.findById(locationId)).thenReturn(Optional.of(existingLocation));
        when(locationRespository.save(any(Location.class))).thenReturn(existingLocation);

        LocationDto result = locationService.updateLocation(locationDto, locationId);
        assertNotNull(result);
        assertEquals("Chennai", result.getLocationName());
    }

    @Test
    void testUpdateLocationNotFound() {
        Integer locationId = 1;
        LocationDto locationDto = new LocationDto();

        when(locationRespository.findById(locationId)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> locationService.updateLocation(locationDto, locationId));
    }

    @Test
    void testDeleteLocation() {
        Integer locationId = 1;
        Location existingLocation = new Location();
        existingLocation.setLocationId(locationId);
        existingLocation.setLocationName("Delhi");
        when(locationRespository.findById(locationId)).thenReturn(Optional.of(existingLocation));
        locationService.deleteLocation(locationId);
        verify(locationRespository, times(1)).delete(existingLocation);
    }

}

