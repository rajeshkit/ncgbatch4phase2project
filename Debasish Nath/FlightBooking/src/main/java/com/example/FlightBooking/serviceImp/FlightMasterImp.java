package com.example.FlightBooking.serviceImp;

import com.example.FlightBooking.exception.FlightIdNotFoundException;
import com.example.FlightBooking.exception.FlightSrcDestNotFoundException;
import com.example.FlightBooking.repository.FlightMasterRepository;
import com.example.FlightBooking.service.IFlightMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightMasterImp implements IFlightMasterService {

    @Autowired
    public FlightMasterRepository flightMasterRepository;


    @Override
    public List<String> getAllFlights() {
        List<Object[]> flightMaster = flightMasterRepository.getAllFlights();

        List<String> results = new ArrayList<>();
        for(int i=0; i<flightMaster.size(); i++) {
            String result = "";
            for (int j = 0; j < flightMaster.get(i).length; j++) {
                switch (j) {
                    case 0:
                        result = result + "FlightID : ";
                        break;
                    case 1:
                        result = result + "Available Seats : ";
                        break;
                    case 2:
                        result = result + "Departure Date : ";
                        break;
                    case 3:
                        result = result + "Departure Time : ";
                        break;
                    case 4:
                        result = result + "Fare : ";
                        break;
                    case 5:
                        result = result + "Total Seats : ";
                        break;
                    case 6:
                        result = result + "Airline Name : ";
                        break;
                    case 7:
                        result = result + "Destination : ";
                        break;
                    case 8:
                        result = result + "Source : ";
                        break;
                }
                result = result + flightMaster.get(i)[j] + " , ";
            }
            results.add(result);
            System.out.println(result);
        }
        return results;
    }



    @Override
    public List<String> getFlightById(String f_no) throws FlightIdNotFoundException {
        List<Object[]> flightMaster = flightMasterRepository.getFlightMasterByflightId(f_no);
        if(flightMaster.isEmpty())
        {
            throw new FlightIdNotFoundException("flight id is not found");
        }

        List<String> results = new ArrayList<>();
        for(int i=0; i<flightMaster.size(); i++) {
            String result = "";
            for (int j = 0; j < flightMaster.get(i).length; j++) {
                switch (j) {
                    case 0:
                        result = result + "FlightID : ";
                        break;
                    case 1:
                        result = result + "Available Seats : ";
                        break;
                    case 2:
                        result = result + "Departure Date : ";
                        break;
                    case 3:
                        result = result + "Departure Time : ";
                        break;
                    case 4:
                        result = result + "Fare : ";
                        break;
                    case 5:
                        result = result + "Total Seats : ";
                        break;
                    case 6:
                        result = result + "Airline Name : ";
                        break;
                    case 7:
                        result = result + "Destination : ";
                        break;
                    case 8:
                        result = result + "Source : ";
                        break;
                }
                result = result + flightMaster.get(i)[j] + " , ";
            }
            results.add(result);
            System.out.println(result);
        }
        return results;
    }


    @Override
    public List<String> getFlightBySourceAndDestination(String source, String destination) throws FlightSrcDestNotFoundException {
        List<Object[]> flightMaster = flightMasterRepository.findFlightsBySourceAndDestination(source, destination);
        if(flightMaster.isEmpty())
        {
            throw new FlightSrcDestNotFoundException("Flight Source or Destination Not Application");
        }
        List<String> results = new ArrayList<>();
        for(int i=0; i<flightMaster.size(); i++) {
            String result = "";
            for (int j = 0; j < flightMaster.get(i).length; j++) {
                switch (j) {
                    case 0:
                        result = result + "FlightID : ";
                        break;
                    case 1:
                        result = result + "Available Seats : ";
                        break;
                    case 2:
                        result = result + "Departure Date : ";
                        break;
                    case 3:
                        result = result + "Departure Time : ";
                        break;
                    case 4:
                        result = result + "Fare : ";
                        break;
                    case 5:
                        result = result + "Total Seats : ";
                        break;
                    case 6:
                        result = result + "Airline Name : ";
                        break;
                    case 7:
                        result = result + "Destination : ";
                        break;
                    case 8:
                        result = result + "Source : ";
                        break;
                }
                result = result + flightMaster.get(i)[j] + " , ";
            }
            results.add(result);
//            System.out.println(result);
        }
        return results;
    }

}