package com.example.Toursandtravel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopDestination {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "names") // Change attribute name to avoid conflict with SQL keyword
    private String names;

    private String descriptions;
    private String imageUrl;
    private String location;
    private String availableDate;

    @Column(name = "max_persons")
    private int maxPersons;

    @Column(name = "from_amount")
    private String fromAmount;

}