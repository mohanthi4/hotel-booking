package com.app.hotel_booking.services;

import com.app.hotel_booking.models.Hotel;
import com.app.hotel_booking.repositories.HotelRepository;
import com.app.hotel_booking.views.HotelView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelRepository.save(new Hotel("Mohandhi Hotel", "Kankipadu"));
    }

    public List<HotelView> listHotels(String city) {
        return hotelRepository.findHotelsByCity(city).stream().map((Hotel::project)).toList();
    }

    public String getHotelName(String hotelId) {
        return hotelRepository.findNameById(hotelId);
    }
}
