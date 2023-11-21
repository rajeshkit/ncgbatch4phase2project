package com.example.air_ticket_reservation_system.controller;

import com.example.air_ticket_reservation_system.exceptionhandler.EntityNotFoundException;
import com.example.air_ticket_reservation_system.repository.CancellationRepository;
import com.example.air_ticket_reservation_system.serviceinterfaces.ICancellation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight-cancel-api")
public class CancellationController {
    @Autowired
    ICancellation iCancellation;
    @PostMapping("/cancel")
    public ResponseEntity<String> cancelTicket(@RequestBody String bookingId) throws EntityNotFoundException {
        boolean cancellationStatus = iCancellation.saveCancelTicket(bookingId);
        if (cancellationStatus) {
            return new ResponseEntity<>("Booking canceled successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Booking not found or unable to cancel", HttpStatus.BAD_REQUEST);
        }
    }
}
