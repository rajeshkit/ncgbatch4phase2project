package com.example.air_ticket_reservation_system.service;

import com.example.air_ticket_reservation_system.entity.BookingInfo;
import com.example.air_ticket_reservation_system.exceptionhandler.EntityNotFoundException;
import com.example.air_ticket_reservation_system.repository.CancellationRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.ICancellation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancellationService implements ICancellation {
    @Autowired
    private CancellationRepository cancellationRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean saveCancelTicket(String bookingId) throws EntityNotFoundException {
        try {
            BookingInfo booking = entityManager.find(BookingInfo.class, bookingId);
            if (booking != null) {
                entityManager.remove(booking);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw  new EntityNotFoundException("Booking Id in invalid","Check Booing Id Once Again!");
            // Handle exceptions (e.g., EntityNotFoundException, PersistenceException)
            //return false;
        }
    }
}