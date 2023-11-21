package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Booking;
import com.flightreservation.flight.exception.IdNotFoundException;
import com.flightreservation.flight.repository.IBookingRepo;
import com.flightreservation.flight.service.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BookingServiceTest {

    @Mock
    private IBookingRepo bookingRepo;

    @InjectMocks
    private BookingServiceImpl bookingService;

    private final Logger logger = LoggerFactory.getLogger(BookingServiceTest.class);

    @Test
    public void testBookingDetails() {
        Booking mockBooking = new Booking(/* Add necessary parameters */);
        when(bookingRepo.save(any(Booking.class))).thenReturn(mockBooking);

        Booking result = bookingService.bookingDetails(mockBooking);

        assertNotNull(result);
        // Add more assertions based on the expected behavior of bookingDetails
    }

    @Test
    public void testGetBookingValidId() {
        int validBookingId = 1;
        Booking mockBooking = new Booking(/* Add necessary parameters */);
        when(bookingRepo.existsById(validBookingId)).thenReturn(true);
        when(bookingRepo.findById(validBookingId)).thenReturn(Optional.of(mockBooking));

        Optional<Booking> result = bookingService.getBooking(validBookingId);

        assertTrue(result.isPresent());
        // Add more assertions based on the expected behavior of getBooking for a valid ID
    }

    @Test
    public void testGetBookingInvalidId() {
        int invalidBookingId = 100;
        when(bookingRepo.existsById(invalidBookingId)).thenReturn(false);

        assertThrows(IdNotFoundException.class, () -> bookingService.getBooking(invalidBookingId));
        // Add more assertions based on the expected behavior of getBooking for an invalid ID
    }

    @Test
    public void testGetAllBooking() {
        int customerId = 123; // Replace with a valid customer ID
        List<Booking> mockBookingList = Arrays.asList(
                new Booking(/* Add necessary parameters */),
                new Booking(/* Add necessary parameters */)
                // Add more mock bookings as needed
        );
        when(bookingRepo.findAllBookingByCustomerId(customerId)).thenReturn(mockBookingList);

        List<Booking> result = bookingService.getAllBooking(customerId);

        assertEquals(mockBookingList.size(), result.size());
        // Add more assertions based on the expected behavior of getAllBooking
    }
}