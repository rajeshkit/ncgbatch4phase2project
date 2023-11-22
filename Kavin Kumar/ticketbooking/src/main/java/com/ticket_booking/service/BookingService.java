package com.ticket_booking.service;
import com.ticket_booking.extras.Result;
import com.ticket_booking.entity.Booking;
import com.ticket_booking.entity.Flight;
import com.ticket_booking.exception.NotLoggedInException;
import com.ticket_booking.exception.UnexpectedErrorException;
import com.ticket_booking.exception.ValueNotFoundException;
import com.ticket_booking.repository.BookingInfoRepository;
import com.ticket_booking.repository.CustomerRepository;
import com.ticket_booking.repository.FlightRepository;
import com.ticket_booking.extras.LoggedInId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService implements BookingServiceInterface {
    private final BookingInfoRepository bookingInfoRepository;
    private final CustomerRepository customerRepository;
    private final FlightRepository flightRepository;
    private final LoggedInId loggedInId;


    @Autowired
    public BookingService(
            BookingInfoRepository bookingInfoRepository, CustomerRepository customerRepository,
            FlightRepository flightRepository,
            LoggedInId loggedInId
    ) {
        this.bookingInfoRepository = bookingInfoRepository;
        this.customerRepository = customerRepository;
        this.flightRepository = flightRepository;
        this.loggedInId = loggedInId;
    }
    Logger logger= LoggerFactory.getLogger(BookingService.class);
    String message;

    @Override
    public ResponseEntity<Object> bookTickets(Booking booking) {
        if(loggedInId.getCustomerId()==0){
            message="Sorry you have login first to book tickets";
            throw new NotLoggedInException(message);
        }

        int flightNo= booking.getFlightNumber();
        int customerId=loggedInId.getCustomerId();
        int noOfSeats= booking.getNoOfSeats();
        if(!flightRepository.existsById(flightNo))
        {
            message = String.format("%s Flight not present", flightNo);
            throw new ValueNotFoundException(message);
        }
        booking.setCustomer(customerRepository.findById(customerId));
        booking.setFlight(flightRepository.findById(flightNo));
        Flight flight=flightRepository.findById(flightNo);

        if(bookingInfoRepository.existsById(booking.getBookingId())){
            message="Unexpected error please try again";
            throw new UnexpectedErrorException(message);
        }
        if(flight.getAvailableSeats()<noOfSeats)
        {
            message="Seats not available";
            throw new ValueNotFoundException(message);
        }
        flight.setBookedSeats(flight.getBookedSeats()+noOfSeats);
        flight.setAvailableSeats(flight.getAvailableSeats()-noOfSeats);
        flightRepository.save(flight);
        bookingInfoRepository.save(booking);
        message="booking success!";
        logger.info("booking success!");
        Result result=new Result(true,message);
        return ResponseEntity.ok(result);
    }
    @Override
    public ResponseEntity<Object> getAllBooking() {
        if(loggedInId.getCustomerId()==0){
            message="Sorry you have login first to see your bookings ";
            throw new NotLoggedInException(message);
        }
        List<Booking> bookingList = bookingInfoRepository.findAllBookingInfoByCustomer_Id(loggedInId.getCustomerId());

        for (Booking booking : bookingList) {
            booking.setFlightNumber(booking.getFlight().getFlightNo());
            booking.setCustomerId(loggedInId.getCustomerId());

        }

        logger.info("Fetched all bookings of the customer");
        return new ResponseEntity<>(bookingList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getBooking(int bookingId) {
        if(loggedInId.getCustomerId()==0){
            logger.info("getting");
            message="Sorry you have login first to see your booking ";
            throw new NotLoggedInException(message);
        }
        if(!bookingInfoRepository.existsById(bookingId)){
            message=bookingId+" Booking id not present";
            throw new ValueNotFoundException(message);
        }
        logger.info("Fetched booking of booking id: {}",bookingId);
        Booking booking =bookingInfoRepository.findById(bookingId);
        booking.setCustomerId(loggedInId.getCustomerId());
        booking.setFlightNumber(booking.getFlight().getFlightNo());

        return ResponseEntity.ok(booking);
    }
}
