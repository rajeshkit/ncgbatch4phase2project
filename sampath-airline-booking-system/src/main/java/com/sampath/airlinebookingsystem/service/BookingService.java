package com.sampath.airlinebookingsystem.service;

import com.sampath.airlinebookingsystem.dtos.BookingDto;
import com.sampath.airlinebookingsystem.entity.Booking;
import com.sampath.airlinebookingsystem.entity.Customer;
import com.sampath.airlinebookingsystem.entity.Flight;
import com.sampath.airlinebookingsystem.exeception.ResourceNotFoundException;
import com.sampath.airlinebookingsystem.repository.BookingRespository;
import com.sampath.airlinebookingsystem.repository.CustomerRepository;
import com.sampath.airlinebookingsystem.repository.FlightRespository;
import com.sampath.airlinebookingsystem.service.interfaces.IBookingService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService implements IBookingService {


    private final ModelMapper modelMapper;

    private final BookingRespository bookingRespository;

    private final CustomerRepository customerRepository;

    private final FlightRespository flightRespository;

    Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    public BookingService(ModelMapper modelMapper, BookingRespository bookingRespository, CustomerRepository customerRepository, FlightRespository flightRespository) {
        this.modelMapper = modelMapper;
        this.bookingRespository = bookingRespository;
        this.customerRepository = customerRepository;
        this.flightRespository = flightRespository;
    }

    @Override
    public BookingDto bookTicket(BookingDto bookingDto, Integer customerId, Integer flightId) {
        Customer customer =
                this.customerRepository.findById(customerId).orElseThrow(()-> {
                    logger.error("AIRLINE ID NOT FOUND");
                    return new ResourceNotFoundException("Customer", "customer id", customerId);
                });
        Flight flight =
                this.flightRespository.findById(flightId).orElseThrow(()->{
                    logger.error("AIRLINE ID NOT FOUND");
                    return new ResourceNotFoundException("flight","flight id",flightId);});
        Booking booking = this.modelMapper.map(bookingDto,Booking.class);
        booking.setFlightId(flight);
        booking.setCustomerId(customer);
        booking.setPrice(bookingDto.getSeatsBook()*flight.getFare());

        Booking bookBooking = this.bookingRespository.save(booking);
        return this.modelMapper.map(bookBooking,BookingDto.class);
    }

    @Override
    public List<BookingDto> getBookingDetailsOfFlight(Integer flightId) {
        Flight flight = this.flightRespository.findById(flightId).orElseThrow(()->{
                logger.error("FLIGHT ID NOT FOUND");
        return new ResourceNotFoundException("FLight","flight id",flightId);});
        List<Booking> bookings = this.bookingRespository.findByFlightId(flight);
        return bookings.stream().map(booking -> this.modelMapper.map(booking,BookingDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingDto getBookingDetailsById(Integer bid) {
        Booking booking =
                this.bookingRespository.findById(bid).orElseThrow(()->new ResourceNotFoundException("Bookings","booking id",bid));
        return this.modelMapper.map(booking,BookingDto.class);
    }

    @Override
    public List<BookingDto> getAllBooking() {
        List<Booking> bookings = this.bookingRespository.findAll();
        logger.info("Getting all bookings");
        return bookings.stream().map(booking -> this.modelMapper.map(booking,BookingDto.class)).collect(Collectors.toList());
    }
}
