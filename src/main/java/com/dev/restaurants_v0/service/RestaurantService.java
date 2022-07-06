package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.RestaurantRequest;
import com.dev.restaurants_v0.dto.request.RestaurantUpdateRequest;

import java.util.List;

public interface RestaurantService {
    List<Restaurants> getAllRestaurants()throws Exception;
    String saveRestaurant(RestaurantRequest restaurantRequest)throws Exception;
    String updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    String deleteRestaurantById(Long id)throws Exception;
    //Personals getAllPersonalByRestaurantId(Long restaurantId)throws Exception;
}