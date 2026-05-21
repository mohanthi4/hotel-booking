package com.app.hotel_booking.models;

import com.app.hotel_booking.views.HotelView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hotels")
public class Hotel {
    
    @Id
    private final String id;
    private final String name;
    private final String city;

    public Hotel(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public HotelView project() {
        return new HotelView(id, name, city);
    }
}
