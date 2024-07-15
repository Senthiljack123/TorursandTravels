package com.example.Toursandtravel.service;

 import com.example.Toursandtravel.model.TopDestination;
 import com.example.Toursandtravel.repo.TopDestinationRepository;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.List;

@Service
public class TopDestinationService {

    @Autowired
    private TopDestinationRepository topDestinationRepository;

    public TopDestination saveTopDestination(TopDestination topDestination) {
        return topDestinationRepository.save(topDestination);
    }

    public List<TopDestination> getAllTopDestinations() {
        return topDestinationRepository.findAll();
    }

    public TopDestination getTopDestinationById(Long id) {
        return topDestinationRepository.findById(id).orElse(null);
    }

    public void deleteTopDestination(Long id) {
        topDestinationRepository.deleteById(id);
    }

    public List<TopDestination> searchDestinations(String location, String date, int persons) {
        // Implement the logic to search destinations based on location, date, and persons
        // This is just a placeholder
        return topDestinationRepository.findByLocationAndAvailableDateAndMaxPersonsGreaterThanEqual(location, date, persons);
    }
}
