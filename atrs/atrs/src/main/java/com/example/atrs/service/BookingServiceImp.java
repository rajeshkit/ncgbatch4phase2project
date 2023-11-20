package com.example.atrs.service;

import com.example.atrs.entity.Booking;
import com.example.atrs.entity.FlightMaster;
import com.example.atrs.exception.BookingIdNotFoundException;
import com.example.atrs.exception.InvalidBookingException;
import com.example.atrs.repository.BookingRepository;
import com.example.atrs.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookingServiceImp implements BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImp.class);
    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;
    public BookingServiceImp(BookingRepository bookingRepository, FlightRepository flightRepository){
        this.bookingRepository=bookingRepository;
        this.flightRepository=flightRepository;
    }

    @Override
    public String bookTickets(Booking booking) throws InvalidBookingException {
        List<FlightMaster> flightMaster=  flightRepository.findAll();
        for(FlightMaster gm:flightMaster){
            FlightMaster flightMaster1m1=booking.getFlightNo();
            int flight2=flightMaster1m1.getFlightId();
        if(flight2==gm.getFlightId() && Objects.equals(booking.getDepartDate().toString(), gm.getDprDate().toString()) && gm.getAvaSeats() >= booking.getSeats()) {
                int avaSeats = gm.getAvaSeats()-booking.getSeats() ;
                gm.setAvaSeats(avaSeats);
                flightRepository.save(gm);
                double pri= booking.getSeats()*(double)gm.getFare();
                booking.setPrice(pri);
                bookingRepository.save(booking);
                logger.info("Booking Done Successfully");
                return "Booked Successfully";
            }
            if(flight2!= gm.getFlightId()) {
                logger.error("Sorry!..Booking cannot be done,Recheck the values");
                throw new InvalidBookingException(" Booking cannot be done.Try again by changing the values");
        }
        }
        return "Booked Successfully";
    }
    public Booking searchBookingById(int bookingId){
        Optional<Booking> book=bookingRepository.findById(bookingId);
        Booking book1=null;
        if(book.isPresent()){
            book1=book.get();
        }else{
            logger.error("No such booking is available");
        }
        logger.info("Booking id is present");
return book1;
    }
    public String deleteBooking(int bookingId) throws BookingIdNotFoundException {
        Booking bb=  bookingRepository.findById(bookingId).orElseThrow(()-> new BookingIdNotFoundException("Id not found"));
        FlightMaster fl=bb.getFlightNo();
        fl.setAvaSeats(fl.getAvaSeats()+bb.getSeats());
        flightRepository.save(fl);
        bookingRepository.deleteById(bookingId);
        return "Booking id : "+bookingId+" deleted successfully";
    }
}
