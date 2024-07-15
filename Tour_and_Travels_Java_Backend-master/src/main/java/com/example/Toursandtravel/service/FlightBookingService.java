package com.example.Toursandtravel.service;

import com.example.Toursandtravel.model.FlightBooking;
import com.example.Toursandtravel.repo.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightBookingService {

    @Autowired
    private FlightBookingRepository flightBookingRepository;

    public List<FlightBooking> getAllFlightBookings() {
        return flightBookingRepository.findAll();
    }

    public FlightBooking saveFlightBooking(FlightBooking flightBooking) {
        return flightBookingRepository.save(flightBooking);
    }

    public FlightBooking getFlightBookingById(Long id) {
        return flightBookingRepository.findById(id).orElse(null);
    }

    public void deleteFlightBooking(Long id) {
        flightBookingRepository.deleteById(id);
    }
}