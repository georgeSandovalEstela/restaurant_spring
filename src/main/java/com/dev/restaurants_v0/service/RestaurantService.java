package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants_v0.dto.request.RestaurantUpdateRequest;
import com.dev.restaurants_v0.dto.response.Restaurants.RestaurantPersonalsResponse;

import java.util.List;

public interface RestaurantService {
    List<Restaurants> getAllRestaurants()throws Exception;
    String saveRestaurant(RestaurantsSaveRequest restaurantsSaveRequest)throws Exception;
    String updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    String deleteRestaurantById(Long id)throws Exception;
    RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception;
}