package com.example.Toursandtravel.service;

import com.example.Toursandtravel.model.HotelBooking;
import com.example.Toursandtravel.repo.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBookingService {

    @Autowired
    private HotelBookingRepository hotelBookingRepository;

    public List<HotelBooking> getAllHotelBookings() {
        return hotelBookingRepository.findAll();
    }

    public HotelBooking saveHotelBooking(HotelBooking hotelBooking) {
        return hotelBookingRepository.save(hotelBooking);
    }

    public HotelBooking getHotelBookingById(Long id) {
        return hotelBookingRepository.findById(id).orElse(null);
    }

    public void deleteHotelBooking(Long id) {
        hotelBookingRepository.deleteById(id);
    }
}