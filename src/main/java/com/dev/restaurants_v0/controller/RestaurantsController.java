package com.dev.restaurants_v0.controller;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.base.GlobalResponse;
import com.dev.restaurants_v0.dto.request.RestaurantRequest;
import com.dev.restaurants_v0.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/restaurants")
@RequiredArgsConstructor
@CrossOrigin
public class RestaurantsController {

    final RestaurantService restaurantService;

    @RequestMapping("/save")
    public ResponseEntity<GlobalResponse> saveRestaurants(@RequestBody RestaurantRequest restaurantRequest) throws Exception {
        Restaurants restaurants = restaurantService.saveRestaurant(restaurantRequest);
        return ResponseEntity.ok(GlobalResponse.builder()
                .build());
    }

    @RequestMapping("/view")
    public ResponseEntity<String> helloWorld() throws Exception{
        return ResponseEntity.ok("Hola mundo");
    }

    /*@RequestMapping(value="/{id}")
    public ResponseEntity<Restaurants> getRestaurant(@PathVariable Long id) throws Exception{
        
        return ResponseEntity.ok(Restaurants.builder().id(id).ruc("20145879634").address("Casa").build());
    }*/
}
