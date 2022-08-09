package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.dto.request.PersonalsSaveRequest;
import com.dev.restaurants_v0.dto.response.Personals.PersonalsResponse;

public interface PersonalsService {
    String savePersonals(PersonalsSaveRequest personalsSaveRequest)throws Exception;
    PersonalsResponse findPersonalsById(Long id)throws Exception;
    PersonalsResponse findPersonalsByDocumentNumber(String documentNumber)throws Exception;
    /*List<Restaurants> getAllRestaurants()throws Exception;
    String updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    String deleteRestaurantById(Long id)throws Exception;
    RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception;*/
}