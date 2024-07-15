    package com.example.Toursandtravel.controller;
    import com.example.Toursandtravel.model.Booking;
    import com.example.Toursandtravel.service.BookingService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;


    @RestController
    @RequestMapping("/api/bookings")
    public class BookingController {

        @Autowired
        private BookingService bookingService;

        @PostMapping
        public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
            Booking savedBooking = bookingService.saveBooking(booking);
            return ResponseEntity.ok(savedBooking);
        }

        @GetMapping
        public ResponseEntity<List<Booking>> getAllBookings() {
            List<Booking> bookings = bookingService.getAllBookings();
            return ResponseEntity.ok(bookings);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
            Booking booking = bookingService.getBookingById(id);
            return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        }
    }