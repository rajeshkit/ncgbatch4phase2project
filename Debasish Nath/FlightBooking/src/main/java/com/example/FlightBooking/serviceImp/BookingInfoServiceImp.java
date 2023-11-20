package com.example.FlightBooking.serviceImp;

import com.example.FlightBooking.entity.BookingInfo;
import com.example.FlightBooking.entity.FlightMaster;
import com.example.FlightBooking.exception.FlightIdNotFoundException;
import com.example.FlightBooking.repository.BookingInfoRepository;
import com.example.FlightBooking.repository.FlightMasterRepository;
import com.example.FlightBooking.service.IBookingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingInfoServiceImp implements IBookingInfoService {
    @Autowired
    public BookingInfoRepository bookingInfoRepository;

    @Autowired
    public FlightMasterRepository flightMasterRepository;

    @Override
    public String insertBooking(BookingInfo bookingInfo) throws Exception {
        if(bookingInfoRepository.save(bookingInfo)==null){
            throw new Exception("Booking is not complete");
        }
        List<Object[]> bookingData = getBookingDetailsByBookId2(bookingInfo.getBookingId());
        System.out.println(bookingInfo.getSeatBook());
        Object b = bookingData.get(bookingData.size()-1);
        System.out.println("nn "+bookingData.get(bookingData.size()-1)[0]);

        updateFlight((String) bookingData.get(bookingData.size()-1)[0], bookingInfo.getSeatBook());
        return("Booking Successful! Booking ID: "+bookingInfo.getBookingId() + ", Booking Date: "+bookingInfo.getBookingDate().toLocalDate()+", Departure Date: "+bookingInfo.getDepartDate().toLocalDate());
    }

    @Override
    public void updateFlight(String flightId, int seats) throws Exception {
        Optional<FlightMaster> flightMaster = flightMasterRepository.findById(flightId);
        System.out.println("total available seats "+flightMaster.get().getAvailableSeats());
        System.out.println("seats purchased "+seats);
        flightMaster.get().setAvailableSeats(flightMaster.get().getAvailableSeats() - seats);
        flightMasterRepository.save(flightMaster.get());
    }

    @Override
    public List<String> getBookingDetailsByBookId(Long bookId) throws Exception {
        List<Object[]> bookingInfo = bookingInfoRepository.getBookingDetailsByBookId(bookId);
        if(bookingInfo.isEmpty())
        {
            throw new FlightIdNotFoundException("booking id is not found");
        }
        System.out.println(bookingInfo.get(0)[0]);
        List<String> results = new ArrayList<>();
        for(int i=0; i<bookingInfo.size(); i++) {
            String result = "";
            for (int j = 0; j < bookingInfo.get(i).length; j++) {
                switch (j) {
                    case 0:
                        result = result + "BOOKING DETAILS: FlightID : ";
                        break;
                    case 1:
                        break;
                    case 2:
                        result = result + "Departure Date : ";
                        break;
                    case 3:
                        result = result + "Fare : ";
                        break;
                    case 4:
                        result = result + "Booking ID : ";
                        break;
                    case 5:
                        result = result + "Booking Date : ";
                        break;
                    case 6:
                        result = result + "Booking Seats Booked : ";
                        break;
                }
                if(j==1) {
                    continue;
                }
                result = result + bookingInfo.get(i)[j] + " , ";
            }
            results.add(result);
//            System.out.println(result);
        }
        return (results);
//        return bookingInfo;
    }

    public List<Object[]> getBookingDetailsByBookId2(Long bookId) throws Exception {
        List<Object[]> bookingInfo = bookingInfoRepository.getBookingDetailsByBookId(bookId);
        if(bookingInfo.isEmpty())
        {
            throw new FlightIdNotFoundException("booking id is not found");
        }
        System.out.println(bookingInfo.get(0)[0]);
        return bookingInfo;
    }

}
