package com.app.services;

import com.app.models.Hotel;
import com.app.repositories.HotelRepository;
import com.app.views.HotelView;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelRepository.save(new Hotel("Mohandhi Hotel", "Kankipadu"));
    }

    @Cacheable(value = "city", key = "#city")
    public List<HotelView> listHotels(String city) {
        return hotelRepository.findHotelsByCity(city).stream().map((Hotel::project)).toList();
    }

    public String getHotelName(String hotelId) {
        return hotelRepository.findNameById(hotelId);
    }
}
