package com.example.Toursandtravel.repo;


 import com.example.Toursandtravel.model.Booking;
 import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
