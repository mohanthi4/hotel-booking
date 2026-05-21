package com.app.hotel_booking.services;

import com.app.hotel_booking.models.BookingDetails;
import com.app.hotel_booking.repositories.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean bookHotel(String username, String hotelId, int rooms) {
        bookingRepository.save(new BookingDetails(username, hotelId, rooms));
        return true;
    }
}
