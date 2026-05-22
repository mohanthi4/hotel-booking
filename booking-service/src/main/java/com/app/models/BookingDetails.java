package com.app.models;

import com.app.views.BookingDetailsView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookingDetails {

    @Id
    private String id;
    private final String username;
    private final String hotelId;
    private final int roomsCount;

    public BookingDetails(String username, String hotelId, int roomsCount) {
        this.username = username;
        this.hotelId = hotelId;
        this.roomsCount = roomsCount;
    }

    public BookingDetailsView project() {
        return new BookingDetailsView(username, hotelId, roomsCount);
    }
}
