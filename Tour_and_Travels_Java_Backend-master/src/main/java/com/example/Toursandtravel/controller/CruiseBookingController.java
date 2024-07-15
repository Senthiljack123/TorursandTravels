package com.example.Toursandtravel.controller;


import com.example.Toursandtravel.model.CruiseBooking;
import com.example.Toursandtravel.service.CruiseBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cruise-bookings")
public class CruiseBookingController {

    @Autowired
    private CruiseBookingService cruiseBookingService;

    @GetMapping("/viewall")
    public List<CruiseBooking> viewAllCruiseBookings() {
        return cruiseBookingService.getAllCruiseBookings();
    }

    @PostMapping("/add")
    public ResponseEntity<CruiseBooking> addCruiseBooking(@RequestBody CruiseBooking cruiseBooking) {
        CruiseBooking savedBooking = cruiseBookingService.saveCruiseBooking(cruiseBooking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CruiseBooking> getCruiseBookingById(@PathVariable Long id) {
        CruiseBooking booking = cruiseBookingService.getCruiseBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCruiseBooking(@PathVariable Long id) {
        cruiseBookingService.deleteCruiseBooking(id);
        return ResponseEntity.noContent().build();
    }
}