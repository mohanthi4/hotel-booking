package com.app.hotel_booking.repositories;

import com.app.hotel_booking.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.concurrent.ConcurrentHashMap;

public interface UserRepository extends MongoRepository<User, String> {
//    UserDetails findUserByUsername(String username);

    UserDetails findByUsername(String username);
}
