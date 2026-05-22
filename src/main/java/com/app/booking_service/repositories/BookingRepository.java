package com.app.booking_service.repositories;

import com.app.booking_service.models.BookingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<BookingDetails, String> {
    List<BookingDetails> findBookingDetailsByUsername(String username);

    BookingDetails findByUsernameAndHotelId(String username, String hotelId);
}
