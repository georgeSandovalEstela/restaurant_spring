package com.dev.restaurants.service;

import com.dev.restaurants.domain.Restaurants;
import com.dev.restaurants.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants.dto.request.RestaurantsUpdateRequest;
import com.dev.restaurants.dto.response.Restaurants.RestaurantPersonalsResponse;

import java.util.List;

public interface RestaurantService {
    List<Restaurants> getAllRestaurants()throws Exception;
    String saveRestaurant(RestaurantsSaveRequest restaurantsSaveRequest)throws Exception;
    String updateRestaurant(RestaurantsUpdateRequest restaurantsUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    String deleteRestaurantById(Long id)throws Exception;
    RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception;
}