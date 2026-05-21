package com.app.hotel_booking.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {
    private final String username;
    private final String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
