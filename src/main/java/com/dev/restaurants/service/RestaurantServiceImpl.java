package com.dev.restaurants.service;

import com.dev.restaurants.domain.Restaurants;
import com.dev.restaurants.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants.dto.request.RestaurantsUpdateRequest;
import com.dev.restaurants.dto.response.Restaurants.PersonalsRestaurantsResponse;
import com.dev.restaurants.dto.response.Restaurants.RestaurantPersonalsResponse;
import com.dev.restaurants.repository.PersonalsRespository;
import com.dev.restaurants.repository.RestaurantsRepository;
import com.dev.restaurants.utils.Codes;
import com.dev.restaurants.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    public final RestaurantsRepository restaurantsRepository;
    public final PersonalsRespository personalsRespository;

    @Override
    public List<Restaurants> getAllRestaurants() throws Exception {
        return restaurantsRepository.findALlByState(Integer.valueOf(Constants.STATE_ACTIVE));
    }

    @Override
    public String saveRestaurant(RestaurantsSaveRequest restaurantsSaveRequest) throws Exception {
        Long findByName = restaurantsRepository.findByName(restaurantsSaveRequest.getName());
        if(findByName > 0) return Codes.RESTAURANT_ERROR_NAME;
        restaurantsRepository.save(restaurantsSaveRequest.castModel());
        return Codes.SUCCESS_SAVE;
    }

    @Override
    public String updateRestaurant(RestaurantsUpdateRequest restaurantsUpdateRequest) throws Exception {
        Optional<Restaurants> restaurantsOptional = restaurantsRepository.findByIdAndState(restaurantsUpdateRequest.getId(), Integer.valueOf(Constants.STATE_INACTIVE));
        if(!restaurantsOptional.isPresent()) return Codes.COMMON_ERR_ID_001;
        restaurantsOptional.get().setRuc(restaurantsUpdateRequest.getRuc());
        restaurantsOptional.get().setName(restaurantsUpdateRequest.getName());
        restaurantsOptional.get().setAddress(restaurantsUpdateRequest.getAddress());
        restaurantsOptional.get().setDescription(restaurantsUpdateRequest.getDescription());
        restaurantsOptional.get().setUpdatedAt(new Date());
        restaurantsRepository.save(restaurantsOptional.get());
        return Codes.SUCCESS_UPDATE;
    }

    @Override
    public Restaurants findRestaurantById(Long id) throws Exception {
        Optional<Restaurants> restaurants = restaurantsRepository.findByIdAndState(id, Integer.valueOf(Constants.STATE_ACTIVE));
        return !restaurants.isPresent()?null:restaurants.get();
    }

    @Override
    public String deleteRestaurantById(Long id) throws Exception {
        Optional<Restaurants> restaurants = restaurantsRepository.findByIdAndState(id, Integer.valueOf(Constants.STATE_ACTIVE));
        if (!restaurants.isPresent()) return Codes.COMMON_ERR_ID_001;
        restaurantsRepository.deleteById(id, Integer.valueOf(Constants.STATE_INACTIVE));
        return Codes.SUCCESS_DELETE;
    }

    @Override
    public RestaurantPersonalsResponse getPersonalsByRestaurantId(Long id) throws Exception {
        Optional<Restaurants> restaurants = restaurantsRepository.findByIdAndState(id, Integer.valueOf(Constants.STATE_ACTIVE));
        if(!restaurants.isPresent()) return null;
        List<PersonalsRestaurantsResponse> response = personalsRespository.getPersonalsByRestaurantsId(id);
        return RestaurantPersonalsResponse.builder().personals(response).build();
    }
}
