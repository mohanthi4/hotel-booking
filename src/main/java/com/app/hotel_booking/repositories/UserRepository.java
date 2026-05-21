package com.app.hotel_booking.repositories;

import com.app.hotel_booking.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<Customer, String> {
//    UserDetails findUserByUsername(String username);

    UserDetails findByUsername(String username);
}
