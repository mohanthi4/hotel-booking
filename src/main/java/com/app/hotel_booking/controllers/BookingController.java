package com.app.hotel_booking.controllers;

import com.app.hotel_booking.controllers.requests.BookingRequest;
import com.app.hotel_booking.services.BookingService;
import com.app.hotel_booking.services.HotelService;
import com.app.hotel_booking.views.BookingDetailsView;
import com.app.hotel_booking.views.BookingStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<BookingStatus> bookHotel(@RequestBody BookingRequest bookingRequest) {
        logger.info("Received request to book a hotel");
//        String hotelName = hotelService.getHotelName(bookingRequest.hotelId());
        boolean isBooked = bookingService.bookHotel("mohandhi", bookingRequest.hotel_id(), bookingRequest.rooms());
        return ResponseEntity.ok(new BookingStatus(isBooked));
    }

    @GetMapping
    public List<BookingDetailsView> listBookings() {
        logger.info("Received request to list the hotels booked by user");
        return bookingService.listBookings("mohandhi");
    }
    
}
