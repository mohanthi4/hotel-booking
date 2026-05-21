package com.app.hotel_booking.services;

import com.app.hotel_booking.controllers.UserDetailRequest;
import com.app.hotel_booking.models.Customer;
import com.app.hotel_booking.repositories.UserRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository users;

    public AppUserDetailsService(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserDetailRequest userDetailRequest) {
        UserDetails user = User.builder().passwordEncoder(this.passwordEncoder::encode).password(userDetailRequest.password()).build();

        users.save(new Customer(userDetailRequest.username(), user.getPassword()));
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.users.findByUsername(username);
        if (userDetails == null) throw new UsernameNotFoundException("user name not found!");
        return userDetails;
    }
}
