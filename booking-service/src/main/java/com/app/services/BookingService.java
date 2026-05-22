package com.app.services;

import com.app.models.BookingDetails;
import com.app.repositories.BookingRepository;
import com.app.views.BookingDetailsView;
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
