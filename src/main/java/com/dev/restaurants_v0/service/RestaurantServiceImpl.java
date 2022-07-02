package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.RestaurantRequest;
import com.dev.restaurants_v0.dto.request.RestaurantUpdateRequest;
import com.dev.restaurants_v0.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    public final RestaurantRepository restaurantRepository ;

    @Override
    public List<Restaurants> getAllRestaurants() throws Exception {
        return null;
    }

    @Override
    public String saveRestaurant(RestaurantRequest restaurantRequest) throws Exception {
        restaurantRepository.save(restaurantRequest.castModel());
        return "";
    }

    @Override
    public Restaurants updateRestaurant(RestaurantUpdateRequest restaurantUpdateRequest) throws Exception {
        return null;
    }

    @Override
    public Restaurants findRestaurantById(Long id) throws Exception {
        return null;
    }

    @Override
    public Restaurants deleteRestaurantById(Long id) throws Exception {
        return null;
    }


}
