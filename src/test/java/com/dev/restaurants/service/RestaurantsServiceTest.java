package com.dev.restaurants.service;

import com.dev.restaurants.domain.Restaurants;
import com.dev.restaurants.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants.repository.RestaurantsRepository;
import com.dev.restaurants.utils.Codes;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestaurantsServiceTest {
    @InjectMocks
    RestaurantServiceImpl restaurantService;

    @Mock
    RestaurantsRepository restaurantsRepository;

    @Test
    public void saveRestaurant_SUCCEES_SAVE()throws Exception{
        RestaurantsSaveRequest request = new RestaurantsSaveRequest("20478569843","La favela","Restobar","Desconocido");
        when(restaurantsRepository.findByName(request.getName())).thenReturn(null);
        when(restaurantsRepository.save(Mockito.any(Restaurants.class))).thenReturn(new Restaurants());
        String response = restaurantService.saveRestaurant(request);

        assertEquals(Codes.SUCCESS_SAVE, response);
    }

    @Test
    public void saveRestaurant_ERROR_NAME()throws Exception{
        RestaurantsSaveRequest request = new RestaurantsSaveRequest("20478569843","La favela","Restobar","Desconocido");
        when(restaurantsRepository.findByName(request.getName())).thenReturn(1L);
        String response = restaurantService.saveRestaurant(request);

        assertEquals(Codes.RESTAURANT_ERROR_NAME, response);
    }
}
