package com.app.hotel_booking.controllers;

import com.app.hotel_booking.services.HotelService;
import com.app.hotel_booking.views.HotelView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureRestTestClient
class SearchControllerTest {

    @Autowired
    private RestTestClient client;

    @MockitoBean
    private HotelService hotelService;

    @Test
    void searchHotels() {
        HotelView expectedHotelView =
                new HotelView("H1", "Grandeur", "New York");

        when(hotelService.listHotels("New York"))
                .thenReturn(Collections.singletonList(expectedHotelView));

        List<HotelView> responseBody = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/search/hotels")
                        .queryParam("city", "New York")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<HotelView>>() {
                })
                .returnResult()
                .getResponseBody();
        System.out.println(responseBody);

        assertEquals(1, responseBody.size());
        assertEquals(expectedHotelView, responseBody.get(0));
    }
}