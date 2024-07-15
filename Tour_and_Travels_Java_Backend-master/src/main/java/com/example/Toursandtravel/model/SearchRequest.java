package com.example.Toursandtravel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest {
    private String location;
    private String date;
    private int persons;
}
