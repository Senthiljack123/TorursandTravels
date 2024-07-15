package com.example.Toursandtravel.controller;

import com.example.Toursandtravel.model.SearchRequest;
import com.example.Toursandtravel.model.TopDestination;
import com.example.Toursandtravel.service.TopDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topdestinations")
public class TopDestinationController {

    @Autowired
    private TopDestinationService topDestinationService;

    @PostMapping("/add")
    public ResponseEntity<TopDestination> createTopDestination(@RequestBody TopDestination topDestination) {
        TopDestination savedTopDestination = topDestinationService.saveTopDestination(topDestination);
        return ResponseEntity.ok(savedTopDestination);
    }

    @GetMapping
    public ResponseEntity<List<TopDestination>> getAllTopDestinations() {
        List<TopDestination> topDestinations = topDestinationService.getAllTopDestinations();
        return ResponseEntity.ok(topDestinations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopDestination> getTopDestinationById(@PathVariable Long id) {
        TopDestination topDestination = topDestinationService.getTopDestinationById(id);
        return topDestination != null ? ResponseEntity.ok(topDestination) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopDestination(@PathVariable Long id) {
        topDestinationService.deleteTopDestination(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/search")
    public ResponseEntity<List<TopDestination>> searchDestinations(@RequestBody SearchRequest request) {
        List<TopDestination> destinations = topDestinationService.searchDestinations(request.getLocation(), request.getDate(), request.getPersons());
        return ResponseEntity.ok(destinations);
    }
}