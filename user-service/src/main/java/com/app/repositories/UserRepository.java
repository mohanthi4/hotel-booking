package com.app.repositories;

import com.app.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<Customer, String> {
    UserDetails findByUsername(String username);
}
