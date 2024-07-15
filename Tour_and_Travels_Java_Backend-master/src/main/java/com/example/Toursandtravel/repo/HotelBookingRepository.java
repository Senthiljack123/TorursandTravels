package com.example.Toursandtravel.repo;

import com.example.Toursandtravel.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {
}