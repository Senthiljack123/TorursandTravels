package com.example.Toursandtravel.controller;



import com.example.Toursandtravel.model.HotelBooking;
import com.example.Toursandtravel.service.HotelBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/hotel-bookings")
public class HotelBookingController {

    @Autowired
    private HotelBookingService hotelBookingService;

    @GetMapping("/viewall")
    public List<HotelBooking> viewAllHotelBookings() {
        return hotelBookingService.getAllHotelBookings();
    }

    @PostMapping("/booking")
    public ResponseEntity<HotelBooking> addHotelBooking(@RequestBody HotelBooking hotelBooking) {
        HotelBooking savedBooking = hotelBookingService.saveHotelBooking(hotelBooking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelBooking> getHotelBookingById(@PathVariable Long id) {
        HotelBooking booking = hotelBookingService.getHotelBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelBooking(@PathVariable Long id) {
        hotelBookingService.deleteHotelBooking(id);
        return ResponseEntity.noContent().build();
    }
}