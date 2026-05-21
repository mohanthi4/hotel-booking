package com.app.hotel_booking.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
