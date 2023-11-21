package com.ticket_booking.repository;

import com.ticket_booking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    boolean existsByEmail(String email);
    boolean existsByIdCardNo(String idCardNo);
    Customer findById(int customerId);
    Customer findCustomerByEmail(String email);
}
