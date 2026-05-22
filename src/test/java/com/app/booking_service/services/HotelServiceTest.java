//package com.app.hotel_booking.services;
//
//import com.app.hotel_booking.models.Hotel;
//import com.app.hotel_booking.repositories.HotelRepository;
//import com.app.hotel_booking.views.HotelView;
//import org.junit.jupiter.api.Test;
//import org.mockito.stubbing.OngoingStubbing;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class HotelServiceTest {
//
//    @Test
//    void listHotels(){
//        HotelRepository hotelRepository = mock(HotelRepository.class);
//        Hotel expectedHotel =
//                new Hotel("Grandeur", "New York");
//        when(hotelRepository.findHotelsByCity(anyString())).thenReturn(Collections.singletonList(expectedHotel));
//        HotelService hotelService = new HotelService(hotelRepository);
//        List<HotelView> actual = hotelService.listHotels("New York");
//
//        HotelView expectedHotelView =
//                new Hotel("Grandeur", "New York").project();
//        assertEquals(Collections.singletonList(expectedHotelView),actual);
//    }
//
//}