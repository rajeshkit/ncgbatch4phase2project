package com.example.airticket.service;

import com.example.airticket.entity.Flight;
import com.example.airticket.repository.BookingRepository;
import com.example.airticket.repository.FlightRepository;
import com.example.airticket.entity.Booking;
import com.example.airticket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    private final CustomerRepository customerRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, FlightRepository flightRepository, CustomerRepository customerRepository){
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    public void bookFlight(Booking booking) {
        booking.setFlight(flightRepository.findById(booking.getFlightNumber()));
        booking.setCustomer(customerRepository.findById(booking.getCustomerNumber()));
        List<Flight> flight = flightRepository.findAll();
        for (Flight flight1 : flight) {
            Flight fm1 = booking.getFlight();
            long flight2 = fm1.getFlightNumber();
            if (flight2 == flight1.getFlightNumber() && (flight1.getAvailableSeats() >= booking.getSeatsToBook())) {
                    int availabeSeats = flight1.getAvailableSeats() - booking.getSeatsToBook();
                    flight1.setAvailableSeats(availabeSeats);
                    flightRepository.save(flight1);
                    int price = booking.getSeatsToBook() * flight1.getFare();
                    booking.setTotalPrice(price);
                    bookingRepository.save(booking);

            }
        }
        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket Booked Successfully");
    }

    @Override
    public ResponseEntity<Object> getAllBookings () {
        List<Booking> bookings = bookingRepository.findAll();
        if (bookings.isEmpty()) {
            String msg = "There is no data in booking table";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(bookings);
        }
    }

    @Override
    public List<Booking> findByDate(LocalDate bookingDate) {
        return bookingRepository.findByBookingDate(bookingDate);
    }


}
