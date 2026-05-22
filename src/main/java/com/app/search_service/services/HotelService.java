package com.app.search_service.services;

import com.app.search_service.models.Hotel;
import com.app.search_service.repositories.HotelRepository;
import com.app.search_service.views.HotelView;
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
