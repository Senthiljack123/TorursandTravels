package com.example.Toursandtravel.controller;

import com.example.Toursandtravel.model.AddTourPackage;
import com.example.Toursandtravel.service.AddTourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("package")
public class AddTourPackageController {
    @Autowired
    private AddTourPackageService  addTourPackageService;

    @GetMapping("/viewall")
    public List<AddTourPackage> viewAllTourDetails() {
        return addTourPackageService.getAllTourDetails();
    }

    @PostMapping("/add")
    public AddTourPackage addTourDetail(@RequestBody AddTourPackage tourDetail) {
        return addTourPackageService.saveTourDetail(tourDetail);
    }


    @GetMapping("/cities")
    public List<String> getCitiesByCountry(@RequestParam String countryName) {
        return addTourPackageService.getCitiesByCountryName(countryName);
    }
}
