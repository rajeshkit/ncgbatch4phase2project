package com.flightreservation.flight.service;

import com.flightreservation.flight.entity.Booking;
import com.flightreservation.flight.exception.IdNotFoundException;
import com.flightreservation.flight.repository.IBookingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookingServiceImpl implements IBookingService {

    private final IBookingRepo bookingRepo;

     final Booking booking;
    String message;

    @Autowired
    public BookingServiceImpl(IBookingRepo bookingRepo, Booking booking) {
        this.bookingRepo = bookingRepo;
        this.booking = booking;
    }

    Logger logger= LoggerFactory.getLogger(BookingServiceImpl.class);
    @Override
    public Booking bookingDetails(Booking book) {

        return bookingRepo.save(book);
    }


    @Override
    public Optional<Booking> getBooking(int bId) {
        if(bookingRepo.existsById(bId)){
            logger.info("Booking id details:");
            return bookingRepo.findById(bId);
        }
        else{
            message="Booking id not found";
            throw new IdNotFoundException(message);
        }
    }

    @Override
    public List<Booking> getAllBooking(int customerId) {
        List<Booking> book=bookingRepo.findAllBookingByCustomerId(customerId);
        List<Booking> bookingList=new ArrayList<>();
        for(Booking b:book) {
            bookingList.add(b);
        }
        logger.info("All bookings are displayed!");
        return bookingList;
    }


}



