package com.dev.restaurants_v0.service;


import com.dev.restaurants_v0.domain.Persons;
import com.dev.restaurants_v0.dto.request.PersonsSaveRequest;

public interface PersonsService {
    String savePersons(PersonsSaveRequest personsSaveRequest)throws Exception;
    Persons findPersonsByDocument(String documentNumber)throws Exception;
    /*List<Restaurants> getAllRestaurants()throws Exception;
    String updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception;
    Restaurants findRestaurantById(Long id)throws Exception;
    String deleteRestaurantById(Long id)throws Exception;
    RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception;*/
}