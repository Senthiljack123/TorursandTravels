package com.example.Toursandtravel.service;

import com.example.Toursandtravel.model.AddTourPackage;
import com.example.Toursandtravel.repo.AddTourPackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddTourPackageService {
    @Autowired
    private AddTourPackageRepo addTourPackageRepo;

    public List<AddTourPackage> getAllTourDetails() {
        return addTourPackageRepo.findAll();
    }

    public AddTourPackage saveTourDetail(AddTourPackage tourDetail) {
        return addTourPackageRepo.save(tourDetail);
    }

    public List<String> getCitiesByCountryName(String countryName) {
        return addTourPackageRepo.findAll()
                .stream()
                .filter(tourDetail -> tourDetail.getCountryName().equalsIgnoreCase(countryName))
                .flatMap(tourDetail -> tourDetail.getCities().stream())
                .distinct()
                .collect(Collectors.toList());
    }
}
