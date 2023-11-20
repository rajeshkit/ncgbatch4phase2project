package com.example.airticket.service;

import com.example.airticket.entity.Booking;
import com.example.airticket.exception.CustomerIdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingServiceImp {

   boolean flightBooking(Booking booking);
   List<Booking> getCustomerBooking(Long customerId) throws CustomerIdNotFoundException;
}
