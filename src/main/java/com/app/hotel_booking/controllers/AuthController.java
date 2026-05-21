package com.app.hotel_booking.controllers;

import com.app.hotel_booking.controllers.UserDetailRequest;
import com.app.hotel_booking.services.AppUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthController {
    private final AppUserDetailsService appUserDetailsService;
    private static final Logger logger = LoggerFactory.getLogger("ldkj");

    public AuthController(AppUserDetailsService appUserDetailsService) {
        this.appUserDetailsService = appUserDetailsService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDetailRequest userDetailRequest) {
        logger.info("register request: {}", userDetailRequest.username());
        appUserDetailsService.register(userDetailRequest);

        return  ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDetailRequest userDetailRequest) {
        logger.info("login request: {}", userDetailRequest.username());
        appUserDetailsService.loadUserByUsername(userDetailRequest.username());

        return  ResponseEntity.ok().build();
    }
}
