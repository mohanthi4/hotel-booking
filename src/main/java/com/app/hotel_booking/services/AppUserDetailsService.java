package com.app.hotel_booking.services;

import com.app.hotel_booking.controllers.UserDetailRequest;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class AppUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final ConcurrentHashMap<String, UserDetails> users;

    public AppUserDetailsService(ConcurrentHashMap<String, UserDetails> users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserDetailRequest userDetailRequest) {
        UserDetails user = User.builder()
                .passwordEncoder(this.passwordEncoder::encode)
                .username(userDetailRequest.username())
                .password(userDetailRequest.password())
                .build();
        this.users.put(user.getUsername(), user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = this.users.get(username);
        if (userDetails == null) throw new UsernameNotFoundException("user name not found!");
        return userDetails;
    }

//    public void login(UserDetailRequest userDetailRequest) {
//
//    }
}
