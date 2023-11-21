package com.ats.service;

import com.ats.entity.*;
import com.ats.exception.BookingException;
import com.ats.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Service
public class BookingServiceImpl implements IBookingService{
    private final IBookingRepository reservationRepository;
    private final ICurrentAdminSessionRepository currentAdminSessionRepository;
    private final ICurrentUserSessionRepository currentUserSessionRepository;
    private final IFlightRepository flightRepository;
    private final IUserRepository userRepository;

    @Autowired
    public BookingServiceImpl(
            IBookingRepository reservationRepository,
            ICurrentAdminSessionRepository currentAdminSessionRepository,
            ICurrentUserSessionRepository currentUserSessionRepository,
            IFlightRepository flightRepository,
            IUserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.currentAdminSessionRepository = currentAdminSessionRepository;
        this.currentUserSessionRepository = currentUserSessionRepository;
        this.flightRepository = flightRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Booking addBooking(BookingDTO dto, String key) throws BookingException {

        CurrentUserSession userSession = currentUserSessionRepository.findByUuid(key);

        if(userSession == null) throw new BookingException("Invalid Session key for user");

        Integer userIdInteger = userSession.getUserID();

        Optional<User> optional = userRepository.findById(userIdInteger);

        if(optional.isEmpty()) throw new BookingException("User not found with the session key");

        User user = optional.get();

        Flight flight = flightRepository.findByRouteFromAndRouteTo(dto.getSource(), dto.getDestination());

        if(flight == null) throw new BookingException("Bus not found for the given starting to destination");

        Integer availableSeats = flight.getAvailableSeats();

        if(availableSeats < dto.getBookedSeat()) throw new BookingException("Only " + availableSeats + " seats are available");

        availableSeats -= dto.getBookedSeat();

        flight.setAvailableSeats(availableSeats);

        Booking reservation = new Booking();

        if(dto.getJourneyDate().isBefore(LocalDate.now())) throw  new BookingException("Journey Date should be in Future");

        reservation.setSource(dto.getSource());
        reservation.setDestination(dto.getDestination());
        reservation.setDate(dto.getJourneyDate());
        reservation.setStatus("Successful");
        reservation.setDate(LocalDate.now());
        reservation.setTime(LocalTime.now());
        reservation.setJourneyDate(dto.getJourneyDate());
        reservation.setFlight(flight);
        reservation.setFare(flight.getFare() * dto.getBookedSeat());
        reservation.setBookedSeat(dto.getBookedSeat());
        reservation.setUser(user);

        return reservationRepository.save(reservation);
    }

    @Override
    public Booking viewBooking(Integer rid, String key) throws BookingException {

        CurrentAdminSession currentAdminSession = currentAdminSessionRepository.findByaid(key);


        if(currentAdminSession == null) throw new BookingException("Invalid admin login key");

        Optional<Booking> optional = reservationRepository.findById(rid);

        if(optional.isEmpty()) throw new BookingException("Reservation with given id is not found");

        return optional.get();
    }

    @Override
    public List<Booking> getAllBooking(String key) throws BookingException {

        CurrentAdminSession session = currentAdminSessionRepository.findByaid(key);

        if(session == null) throw new BookingException("Please provide valid admin login key");

        List<Booking> list = reservationRepository.findAll();

        if(list.isEmpty()) throw new BookingException("Reservation Not found");

        return list;
    }

    @Override
    public List<Booking> viewBookingsByUerId(Integer uid, String key) throws BookingException {

        CurrentAdminSession currentAdminSession = currentAdminSessionRepository.findByaid(key);

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByUuid(key);

        if(currentAdminSession == null && currentUserSession == null) throw new BookingException("Invalid login key");


        Optional<User> optional = userRepository.findById(uid);

        if(optional.isEmpty()) throw new BookingException("User not find with given user id: " + uid);

        User user = optional.get();

        List<Booking> reservations = user.getBookingList();

        if(reservations.isEmpty()) throw new BookingException("Reservation not found for this user");

        return reservations;
    }

    @Override
    public Booking deleteBooking(Integer rid, String key) throws BookingException{

        CurrentUserSession currentUserSession = currentUserSessionRepository.findByUuid(key);

        if(currentUserSession == null) throw new BookingException("Invalid session key");

        Optional<Booking> optional =  reservationRepository.findById(rid);

        if(optional.isEmpty()) throw new BookingException("Reservation not found with the given id: " + rid);

        Booking booking = optional.get();

        if(booking.getJourneyDate().isBefore(LocalDate.now())) throw new BookingException("Reservation Already Expired");

        Integer n = booking.getFlight().getAvailableSeats();

        booking.getFlight().setAvailableSeats(n + booking.getBookedSeat());

        Flight flight = booking.getFlight();

        flightRepository.save(flight);
        reservationRepository.delete(booking);

        return booking;
    }

    @Override
    public Booking updateBooking(Integer rid, BookingDTO dto, String key) throws BookingException {

        CurrentUserSession userSession = currentUserSessionRepository.findByUuid(key);

        if(userSession == null) throw new BookingException("Invalid Session key for user");

        Flight flight = flightRepository.findByRouteFromAndRouteTo(dto.getSource(), dto.getDestination());

        if(flight == null) throw new BookingException("Bus not found for the given starting to destination");

        Integer availableSeats = flight.getAvailableSeats();

        if(availableSeats < dto.getBookedSeat()) throw new BookingException("Only " + availableSeats + " seats are available");

        availableSeats -= dto.getBookedSeat();

        flight.setAvailableSeats(availableSeats);

        Optional<Booking> optional = reservationRepository.findById(rid);

        if(optional.isEmpty()) throw new BookingException("Reservation not found with the given id: " + rid);

        Booking booking  = optional.get();
        booking.setBookedSeat(dto.getBookedSeat());
        booking.setFlight(flight);
        booking.setDate(dto.getJourneyDate());
        booking.setDestination(dto.getDestination()) ;
        booking.setFare(flight.getFare());
        booking.setJourneyDate(dto.getJourneyDate());
        booking.setSource(dto.getSource());
        booking.setDate(LocalDate.now());
        booking.setTime(LocalTime.now());

        reservationRepository.save(booking);

        return booking;
    }
}
