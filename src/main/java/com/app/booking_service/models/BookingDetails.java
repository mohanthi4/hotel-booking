package com.app.booking_service.models;

import com.app.booking_service.views.BookingDetailsView;
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
