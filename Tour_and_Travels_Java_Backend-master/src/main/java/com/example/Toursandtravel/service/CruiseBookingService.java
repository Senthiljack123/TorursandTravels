package com.example.Toursandtravel.service;

import com.example.Toursandtravel.model.CruiseBooking;
import com.example.Toursandtravel.repo.CruiseBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CruiseBookingService {
    @Autowired
    private CruiseBookingRepository cruiseBookingRepository;

    public List<CruiseBooking> getAllCruiseBookings() {
        return cruiseBookingRepository.findAll();
    }

    public CruiseBooking saveCruiseBooking(CruiseBooking cruiseBooking) {
        return cruiseBookingRepository.save(cruiseBooking);
    }

    public CruiseBooking getCruiseBookingById(Long id) {
        return cruiseBookingRepository.findById(id).orElse(null);
    }

    public void deleteCruiseBooking(Long id) {
        cruiseBookingRepository.deleteById(id);
    }
}
