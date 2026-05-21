package com.app.hotel_booking.repositories;

import com.app.hotel_booking.models.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<BookingDetails, String> {
    List<BookingDetails> findBookingDetailsByUsername(String username);
}
