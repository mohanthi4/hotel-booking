package com.app.booking_service.services;

import com.app.booking_service.models.BookingDetails;
import com.app.booking_service.repositories.BookingRepository;
import com.app.booking_service.views.BookingDetailsView;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BookingDetailsView> listBookings(String username) {
        return bookingRepository.findBookingDetailsByUsername(username)
                .stream()
                .map((BookingDetails::project))
                .toList();
    }

    public BookingDetailsView bookDetails(String username, String hotelId) {
        return bookingRepository.findByUsernameAndHotelId(username, hotelId).project();
    }
}
