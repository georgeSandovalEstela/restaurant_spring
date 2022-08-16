package com.dev.restaurants.service;

import com.dev.restaurants.domain.Restaurants;
import com.dev.restaurants.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants.dto.request.RestaurantsUpdateRequest;
import com.dev.restaurants.repository.RestaurantsRepository;
import com.dev.restaurants.utils.Codes;
import com.dev.restaurants.utils.Constants;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

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
    @Test
    public void findRestaurantById_SUCCESS()throws Exception{
        when(restaurantsRepository.findByIdAndState(100L,Integer.valueOf(Constants.STATE_ACTIVE))).thenReturn(Optional.of(new Restaurants()));
        Restaurants response = restaurantService.findRestaurantById(100L);

        assertFalse(Objects.isNull(response));
    }

    @Test
    public void findRestaurantById_NOT_FOUND()throws Exception{
        when(restaurantsRepository.findByIdAndState(100L,Integer.valueOf(Constants.STATE_ACTIVE))).thenReturn(Optional.empty());
        Restaurants response = restaurantService.findRestaurantById(100L);

        assertTrue(Objects.isNull(response));
    }

   /* @Test
    public void updateRestaurant_SUCCESS_UPDATE()throws Exception{
        Restaurants restaurants = new Restaurants(104L,"20987654324","Tunki","Restobar","Castillo",new Date(),new Date(),null,1);
        RestaurantsUpdateRequest request = new RestaurantsUpdateRequest(104L,"20987654324","Tunki","RESTOBAR","DESCONOCIDO");
        when(restaurantsRepository.findByIdAndState(104L,Integer.valueOf(Constants.STATE_ACTIVE))).thenReturn(Optional.of(restaurants));
        when(restaurantsRepository.save(Mockito.any(Restaurants.class))).thenReturn(restaurants);
        String response = restaurantService.updateRestaurant(request);

        assertEquals(Codes.SUCCESS_UPDATE, response);
    }*/

    @Test
    public void updateRestaurant_ERROR_ID()throws Exception{
        when(restaurantsRepository.findByIdAndState(100L,Integer.valueOf(Constants.STATE_ACTIVE))).thenReturn(Optional.empty());
        String response = restaurantService.updateRestaurant(new RestaurantsUpdateRequest());

        assertEquals(Codes.COMMON_ERR_ID_001, response);
    }
}
