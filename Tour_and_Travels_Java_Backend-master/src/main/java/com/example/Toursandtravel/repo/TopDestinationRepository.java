package com.example.Toursandtravel.repo;

import com.example.Toursandtravel.model.TopDestination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopDestinationRepository extends JpaRepository<TopDestination, Long> {
    List<TopDestination> findByLocationAndAvailableDateAndMaxPersonsGreaterThanEqual(String location, String availableDate, int persons);

}