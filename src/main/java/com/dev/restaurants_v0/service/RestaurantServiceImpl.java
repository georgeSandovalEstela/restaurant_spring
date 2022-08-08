package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants_v0.dto.request.RestaurantUpdateRequest;
import com.dev.restaurants_v0.dto.response.Restaurants.PersonalsRestaurantsResponse;
import com.dev.restaurants_v0.dto.response.Restaurants.RestaurantPersonalsResponse;
import com.dev.restaurants_v0.repository.PersonalsRespository;
import com.dev.restaurants_v0.repository.RestaurantRepository;
import com.dev.restaurants_v0.utils.Codes;
import com.dev.restaurants_v0.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    public final RestaurantRepository restaurantRepository ;
    public final PersonalsRespository personalsRespository;

    @Override
    public List<Restaurants> getAllRestaurants() throws Exception {
        return restaurantRepository.findALlByState(Integer.valueOf(Constants.STATE_ACTIVE));
    }

    @Override
    public String saveRestaurant(RestaurantsSaveRequest restaurantsSaveRequest) throws Exception {
        Long findByName = restaurantRepository.findByName(restaurantsSaveRequest.getName());
        if(findByName > 0) return Codes.RESTAURANT_ERROR_NAME;
        restaurantRepository.save(restaurantsSaveRequest.castModel());
        return Codes.SUCCESS_SAVE;
    }

    @Override
    public String updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception {
        Optional<Restaurants> restaurantsOptional = restaurantRepository.findByIdAndState(restaurantUpdateRequest.getId(), Integer.valueOf(Constants.STATE_INACTIVE));
        if(!restaurantsOptional.isPresent()) return Codes.COMMON_ERR_ID_001;
        restaurantsOptional.get().setRuc(restaurantUpdateRequest.getRuc());
        restaurantsOptional.get().setName(restaurantUpdateRequest.getName());
        restaurantsOptional.get().setAddress(restaurantUpdateRequest.getAddress());
        restaurantsOptional.get().setDescription(restaurantUpdateRequest.getDescription());
        restaurantsOptional.get().setUpdatedAt(new Date());
        restaurantRepository.save(restaurantsOptional.get());
        return Codes.SUCCESS_UPDATE;
    }

    @Override
    public Restaurants findRestaurantById(Long id) throws Exception {
        Optional<Restaurants> restaurants = restaurantRepository.findByIdAndState(id, Integer.valueOf(Constants.STATE_ACTIVE));
        return !restaurants.isPresent()?null:restaurants.get();
    }

    @Override
    public String deleteRestaurantById(Long id) throws Exception {
        Optional<Restaurants> restaurants = restaurantRepository.findByIdAndState(id, Integer.valueOf(Constants.STATE_ACTIVE));
        if (!restaurants.isPresent()) return Codes.COMMON_ERR_ID_001;
        restaurantRepository.deleteById(id, Integer.valueOf(Constants.STATE_INACTIVE));
        return Codes.SUCCESS_DELETE;
    }

    @Override
    public RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception {
        Optional<Restaurants> restaurants = restaurantRepository.findByIdAndState(id, Integer.valueOf(Constants.STATE_ACTIVE));
        if(!restaurants.isPresent()) return null;
        List<PersonalsRestaurantsResponse> response = personalsRespository.getPersonalsByRestaurantsId(id);
        return RestaurantPersonalsResponse.builder().personals(response).build();
    }
}
