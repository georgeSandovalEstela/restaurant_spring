package com.dev.restaurants_v0.controller;

import com.dev.restaurants_v0.dto.base.GlobalResponse;
import com.dev.restaurants_v0.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants_v0.dto.request.RestaurantsUpdateRequest;
import com.dev.restaurants_v0.service.RestaurantService;
import com.dev.restaurants_v0.utils.Codes;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.when;

@SpringBootTest
public class RestaurantsControllerTest {
    @InjectMocks
    RestaurantsController restaurantsController;

    @Mock
    RestaurantService restaurantService;

    @Test
    public void saveRestaurants_SUCCESS_SAVE()throws Exception{
        RestaurantsSaveRequest request = new RestaurantsSaveRequest("20478569843","La favela","Restobar","Desconocido");
        when(restaurantService.saveRestaurant(request)).thenReturn(Codes.SUCCESS_SAVE);
        ResponseEntity<GlobalResponse> response = restaurantsController.saveRestaurants(request);
        assertTrue((Boolean) response.getBody().getData());
    }

    @Test
    public void saveRestaurants_ERROR_NAME()throws Exception{
        RestaurantsSaveRequest request = new RestaurantsSaveRequest("20478569843","La favela","Restobar","Desconocido");
        when(restaurantService.saveRestaurant(request)).thenReturn(Codes.RESTAURANT_ERROR_NAME);
        ResponseEntity<GlobalResponse> response = restaurantsController.saveRestaurants(request);
        assertEquals(Codes.RESTAURANT_ERROR_NAME, response.getBody().getError().getCode());
    }

    @Test
    public void updateRestaurants_SUCCESS_UPDATE()throws Exception{
        RestaurantsUpdateRequest request = new RestaurantsUpdateRequest(100L,"20478569843","La favela","Restobar","Desconocido");
        when(restaurantService.updateRestaurant(request)).thenReturn(Codes.SUCCESS_UPDATE);
        ResponseEntity<GlobalResponse> response = restaurantsController.updateRestaurants(request);
        assertTrue((Boolean) response.getBody().getData());
    }
}
