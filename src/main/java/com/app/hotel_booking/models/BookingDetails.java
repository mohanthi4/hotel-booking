package com.app.hotel_booking.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookingDetails {

    @Id
    private String id;
    private final String username;
    private final String hotelName;
    private final int roomsCount;

    public BookingDetails(String username, String hotelName, int roomsCount) {
        this.username = username;
        this.hotelName = hotelName;
        this.roomsCount = roomsCount;
    }
}
