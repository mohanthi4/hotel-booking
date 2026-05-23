package com.app.controllers;

import com.app.services.HotelService;
import com.app.views.HotelView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
    private final HotelService hotelService;

    public SearchController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/api/search")
    public List<HotelView> searchHotels(@RequestParam String city) {
        logger.info("Received request to search hotels");
        return hotelService.listHotels(city);
    }

}
