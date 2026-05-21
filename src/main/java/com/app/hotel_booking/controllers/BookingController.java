package com.app.hotel_booking.controllers;

import com.app.hotel_booking.controllers.requests.BookingRequest;
import com.app.hotel_booking.services.BookingService;
import com.app.hotel_booking.services.HotelService;
import com.app.hotel_booking.utils.JwtUtil;
import com.app.hotel_booking.views.BookingDetailsView;
import com.app.hotel_booking.views.BookingStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
    private final BookingService bookingService;
    private final HotelService hotelService;

    public BookingController(BookingService bookingService, HotelService hotelService) {
        this.bookingService = bookingService;
        this.hotelService = hotelService;
    }

    private String getUsername(HttpServletRequest request) {
        String authHeader =
                request.getHeader("Authorization");

        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            return "No token";
        }

        String token =
                authHeader.substring(7);

        return JwtUtil.extractUsername(token);
    }

    @PostMapping
    public ResponseEntity<BookingStatus> bookHotel(@RequestBody BookingRequest bookingRequest, HttpServletRequest request) {

        logger.info("Received request to book a hotel");
        String username = getUsername(request);
        boolean isBooked = bookingService.bookHotel(username, bookingRequest.hotel_id(), bookingRequest.rooms());
        return ResponseEntity.ok(new BookingStatus(isBooked));
    }

    @GetMapping
    public List<BookingDetailsView> listBookings(HttpServletRequest request) {
        logger.info("Received request to list the hotels booked by user");
        String username = getUsername(request);
        return bookingService.listBookings(username);
    }

    @GetMapping("/{hotelId}/receipt.pdf")
    public ResponseEntity<String> generateReceipt(@PathVariable String hotelId, HttpServletRequest request) {
        logger.info("Received request to download receipt");
        String username = getUsername(request);
        BookingDetailsView bookingDetails = bookingService.bookDetails(username, hotelId);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().build());
        return new ResponseEntity<>(bookingDetails.toString(), headers, HttpStatus.OK);
    }
}
