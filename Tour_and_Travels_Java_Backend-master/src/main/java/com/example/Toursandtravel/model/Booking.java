package com.example.Toursandtravel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    private int noOfPassengers;
    private int noOfLuggages;
    private String pickupLocation;
    private String dropoffLocation;
    private String date;
    private String time;
    private String selectionServiceType;
    private String vehicleType;
    private double addonCharges;
    private String paymentType;
    private String additionalInformation;
}
