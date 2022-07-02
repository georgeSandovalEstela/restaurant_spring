package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.RestaurantRequest;
import com.dev.restaurants_v0.dto.request.RestaurantUpdateRequest;

import java.util.List;

public interface RestaurantService {
    List<Restaurants> getAllRestaurants()throws Exception;
    Restaurants saveRestaurant(RestaurantRequest restaurantRequest)throws Exception;
    Restaurants updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    Restaurants deleteRestaurantById(Long id)throws Exception;
    //Personals getAllPersonalByRestaurantId(Long restaurantId)throws Exception;
}