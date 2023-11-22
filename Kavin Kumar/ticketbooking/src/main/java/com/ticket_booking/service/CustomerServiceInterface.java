package com.ticket_booking.service;
import com.ticket_booking.entity.Customer;
import com.ticket_booking.entity.Flight;
import org.springframework.http.ResponseEntity;

public interface CustomerServiceInterface {
    public ResponseEntity<Object> register(Customer customer);
    public ResponseEntity<Object> customerLogin(Customer login);

    ResponseEntity<Object> findCustomer(int customerId);
    ResponseEntity<Object> findCustomer(String customerEmail);

    ResponseEntity<Object> getAllFlights(Flight flight);

    ResponseEntity<Object> logout();
}
