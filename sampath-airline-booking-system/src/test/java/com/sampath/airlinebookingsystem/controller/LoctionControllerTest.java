package com.sampath.airlinebookingsystem.controller;

import com.sampath.airlinebookingsystem.dtos.ApiResponse;
import com.sampath.airlinebookingsystem.dtos.LocationDto;
import com.sampath.airlinebookingsystem.service.interfaces.ILocationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LocationControllerTest {

    @Mock
    private ILocationService locationService;

    @InjectMocks
    private LocationController locationController;

    public LocationControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLocation() {
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationName("Hyd");
        when(locationService.createLocation(locationDto)).thenReturn(locationDto);
        ResponseEntity<LocationDto> responseEntity = locationController.createLocation(locationDto);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Hyd", responseEntity.getBody().getLocationName());
    }

    @Test
    void testUpdateLocation() {
        Integer locationId = 1;
        LocationDto locationDto = new LocationDto();
        locationDto.setLocationName("Pune");
        when(locationService.updateLocation(locationDto, locationId)).thenReturn(locationDto);
        ResponseEntity<LocationDto> responseEntity = locationController.updateLocation(locationDto, locationId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Pune", responseEntity.getBody().getLocationName());
    }

    @Test
    void testDeleteLocation() {
        Integer locationId = 1;
        ResponseEntity<ApiResponse> responseEntity = locationController.deleteLocation(locationId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody().getSuccess());
    }

    @Test
    void testGetAllLocation() {
        List<LocationDto> locationDtos = Arrays.asList(
                new LocationDto(1,"chennai"),
                new LocationDto(2, "Hyderabad")
        );
        when(locationService.getAllLocations()).thenReturn(locationDtos);
        ResponseEntity<List<LocationDto>> responseEntity = locationController.getAllLocation();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    void testGetLocation() {
        Integer locationId = 1;
        LocationDto locationDto = new LocationDto(locationId, "Hyderabad");
        when(locationService.getLocation(locationId)).thenReturn(locationDto);
        ResponseEntity<LocationDto> responseEntity = locationController.getLocation(locationId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Hyderabad", responseEntity.getBody().getLocationName());
    }
}
