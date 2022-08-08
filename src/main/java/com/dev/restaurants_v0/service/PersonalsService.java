package com.dev.restaurants_v0.service;


import com.dev.restaurants_v0.dto.request.PersonalsSaveRequest;

public interface PersonalsService {
    String savePersonals(PersonalsSaveRequest personalsSaveRequest)throws Exception;
    /*List<Restaurants> getAllRestaurants()throws Exception;
    String updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    String deleteRestaurantById(Long id)throws Exception;
    RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception;*/
}