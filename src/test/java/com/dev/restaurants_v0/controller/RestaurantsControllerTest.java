package com.dev.restaurants_v0.controller;

import com.dev.restaurants_v0.dto.base.GlobalResponse;
import com.dev.restaurants_v0.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants_v0.service.RestaurantService;
import com.dev.restaurants_v0.utils.Codes;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RestaurantsControllerTest {
    @InjectMocks
    RestaurantsController restaurantsController;

    @Mock
    RestaurantService restaurantService;

    @Test
    public void saveRestaurants_SUCCESS_SAVE()throws Exception{
        RestaurantsSaveRequest request = new RestaurantsSaveRequest("20478569843","La favela","Restobar","Desconocido");
        Mockito.when(restaurantService.saveRestaurant(request)).thenReturn(Codes.SUCCESS_SAVE);
        ResponseEntity<GlobalResponse> response = restaurantsController.saveRestaurants(request);
        assertTrue((Boolean) response.getBody().getData());
    }

}
