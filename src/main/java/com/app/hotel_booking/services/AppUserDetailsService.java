package com.app.hotel_booking.services;

import com.app.hotel_booking.controllers.UserDetailRequest;
import com.app.hotel_booking.models.User;
import com.app.hotel_booking.repositories.UserRepository;
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
//        UserDetails user = User.builder()
//                .passwordEncoder(this.passwordEncoder::encode)
//                .username(userDetailRequest.username())
//                .password(userDetailRequest.password())
//                .build();

        users.save(new User(userDetailRequest.username(), userDetailRequest.password()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.users.findByUsername(username);
        if (userDetails == null) throw new UsernameNotFoundException("user name not found!");
        return userDetails;
    }
}
