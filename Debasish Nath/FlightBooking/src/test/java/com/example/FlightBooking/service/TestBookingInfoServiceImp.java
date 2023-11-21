package com.example.FlightBooking.service;

import com.example.FlightBooking.entity.BookingInfo;
import com.example.FlightBooking.repository.BookingInfoRepository;
import com.example.FlightBooking.serviceImp.BookingInfoServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBookingInfoServiceImp {
    @Mock
    private BookingInfoRepository bookingInfoRepository;
    @InjectMocks
    private BookingInfoServiceImp bookingInfoService;

    @BeforeAll
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        BookingInfo bookingInfo = new BookingInfo();
        bookingInfo.setBookingId(100L);
        bookingInfo.setPrice(100D);
        bookingInfo.setBookingDate(new Date(1,1,2001));
        List<Object[]> details = new ArrayList<>();
        details.add(new Object[]{bookingInfo});
        Mockito.when(bookingInfoRepository.getBookingDetailsByBookId(Mockito.anyLong())).thenReturn(details);
    }

    @Test
    public void testGetBookingDetailsByBookId2() throws Exception {
        Assertions.assertNotNull(bookingInfoService.getBookingDetailsByBookId2(1000L));
    }

    @Test
    public void testGetBookingDetailsByBookId() throws Exception {
        Assertions.assertNotNull(bookingInfoService.getBookingDetailsByBookId(100L));
    }
}
