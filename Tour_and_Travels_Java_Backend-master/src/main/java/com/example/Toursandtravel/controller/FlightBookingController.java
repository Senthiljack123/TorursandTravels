package com.example.Toursandtravel.controller;

import com.example.Toursandtravel.model.FlightBooking;
import com.example.Toursandtravel.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight-bookings")
public class FlightBookingController {

    @Autowired
    private FlightBookingService flightBookingService;

    @GetMapping("/viewall")
    public List<FlightBooking> viewAllFlightBookings() {
        return flightBookingService.getAllFlightBookings();
    }

    @PostMapping("/bookingFlight")
    public ResponseEntity<FlightBooking> addFlightBooking(@RequestBody FlightBooking flightBooking) {
        FlightBooking savedBooking = flightBookingService.saveFlightBooking(flightBooking);
        return ResponseEntity.ok(savedBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightBooking> getFlightBookingById(@PathVariable Long id) {
        FlightBooking booking = flightBookingService.getFlightBookingById(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlightBooking(@PathVariable Long id) {
        flightBookingService.deleteFlightBooking(id);
        return ResponseEntity.noContent().build();
    }
}