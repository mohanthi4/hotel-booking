package com.app.models;

import com.app.views.HotelView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
public class Hotel {

    @Id
    private String id;
    private final String name;
    private final String city;

    public Hotel(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public HotelView project() {
        return new HotelView(id, name, city);
    }
}
