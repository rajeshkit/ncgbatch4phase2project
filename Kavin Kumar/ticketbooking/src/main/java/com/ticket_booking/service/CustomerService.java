package com.ticket_booking.service;
import com.ticket_booking.extras.Result;
import com.ticket_booking.entity.Customer;
import com.ticket_booking.entity.Flight;
import com.ticket_booking.entity.Location;
import com.ticket_booking.exception.UnexpectedErrorException;
import com.ticket_booking.exception.ValueAlreadyExistsException;
import com.ticket_booking.exception.ValueNotFoundException;
import com.ticket_booking.repository.CustomerRepository;
import com.ticket_booking.extras.LoggedInId;
import com.ticket_booking.repository.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface {

    Logger logger= LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;

    private final FlightRepository flightRepository;

    private final LoggedInId loggedInId;


    @Autowired
    public CustomerService(CustomerRepository customerRepository,  FlightRepository flightRepository, LoggedInId loggedInId) {
        this.customerRepository = customerRepository;
        this.flightRepository = flightRepository;
        this.loggedInId = loggedInId;
    }
    String message;
    @Override
    public ResponseEntity<Object> register(Customer customer) {
        if(customerRepository.existsById(customer.getId())){
            message="unexpected error occurred try again later";
            throw new UnexpectedErrorException(message);
        }
        if(customerRepository.existsByEmail(customer.getEmail())) {
            message=customer.getEmail()+" already exists";
            throw new ValueAlreadyExistsException(message);
        }
        if( customerRepository.existsByIdCardNo(customer.getIdCardNo())){
            message=customer.getIdCardNo()+ "id card number already exists";
            throw new ValueAlreadyExistsException(message);
        }
        customerRepository.save(customer);
        message= "Register success! Customer Id:"+customer.getId();
        logger.info(message);
        Result result=new Result(true,message);
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Object> customerLogin(Customer login) {
        if(!customerRepository.existsByEmail(login.getEmail())){
            message= login.getEmail()+"  not registered, check your email!";
            throw new ValueNotFoundException(message);
        }
        Customer customer=customerRepository.findCustomerByEmail(login.getEmail());
        if(customer.getPassword().equals(login.getPassword()))
        {
            message="Customer Login success!";
            loggedInId.setCustomerId(customer.getId());
            logger.info(message);
            Result result=new Result(true,message);
            return ResponseEntity.ok(result);
        }
        message="Wrong password!";
        logger.error(message);
        Result result=new Result(message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }



    @Override
    public ResponseEntity<Object> findCustomer(int customerId) {
       if(!customerRepository.existsById(customerId))
       {
           message=customerId+" Id not present, check the customer id";
           throw new ValueNotFoundException(message);
       }
       logger.info("fetched customer with id: {}",customerId);
       return ResponseEntity.ok(customerRepository.findById(customerId));
    }

    @Override
    public ResponseEntity<Object> findCustomer(String customerEmail) {
       if(!customerRepository.existsByEmail(customerEmail)){
           message=customerEmail+ "not registered, check your email";
           throw new ValueNotFoundException(message);
       }
       logger.info("fetched customer with email: {}",customerEmail);
       return ResponseEntity.ok(customerRepository.findCustomerByEmail(customerEmail));
    }

    @Override
    public ResponseEntity<Object> getAllFlights(Flight flight) {
        LocalDate date=flight.getDepartureDate();
        Location source=flight.getSource();
        Location destination=flight.getDestination();
        List<Flight> flightList=flightRepository.findAllBySourceAndDestinationAndDepartureDateOrderByDepartureTime(source,destination,date);
        if (flightList.isEmpty())
        {
            message="No flights found";
            logger.info(message);
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
        logger.info("fetched the flight details");
        return new ResponseEntity<>(flightList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> logout() {
        loggedInId.setCustomerId(0);
        Result result=new Result(true,"Logout success!");
        return new ResponseEntity<>(result,HttpStatus.OK);
    }


}
