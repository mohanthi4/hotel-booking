package com.app.hotel_booking.repositories;

import com.app.hotel_booking.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    List<Hotel> findHotelsByCity(String city);
    String findNameById(String id);
}
