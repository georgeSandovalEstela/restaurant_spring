package com.dev.restaurants.controller;

import com.dev.restaurants.domain.Restaurants;
import com.dev.restaurants.dto.base.ErrorResponse;
import com.dev.restaurants.dto.base.GlobalResponse;
import com.dev.restaurants.dto.request.RestaurantsSaveRequest;
import com.dev.restaurants.dto.request.RestaurantsUpdateRequest;
import com.dev.restaurants.dto.response.Restaurants.RestaurantPersonalsResponse;
import com.dev.restaurants.service.RestaurantService;
import com.dev.restaurants.utils.Codes;
import com.dev.restaurants.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/restaurants")
@RequiredArgsConstructor
@CrossOrigin
public class RestaurantsController {

    public final RestaurantService restaurantService;

    @GetMapping("")
    public ResponseEntity<GlobalResponse> getAllRestaurants()throws Exception{
        return ResponseEntity.ok(GlobalResponse.builder()
                .data(restaurantService.getAllRestaurants()).build());
    }
    @PostMapping("/save")
    public ResponseEntity<GlobalResponse> saveRestaurants(@RequestBody RestaurantsSaveRequest restaurantsSaveRequest) throws Exception {
        String code = restaurantService.saveRestaurant(restaurantsSaveRequest);
        return ResponseEntity.ok(GlobalResponse.builder()
                                .error((code==Codes.SUCCESS_SAVE)?null: ErrorResponse.builder().code(code).message(Messages.RESTAURANT_ERROR_NAME).build())
                                .data((code==Codes.SUCCESS_SAVE)?true: null).build());
    }

    @PutMapping("/update")
    public ResponseEntity<GlobalResponse> updateRestaurants(@RequestBody RestaurantsUpdateRequest restaurantsUpdateRequest) throws Exception{
        String code = restaurantService.updateRestaurant(restaurantsUpdateRequest);
        return ResponseEntity.ok(GlobalResponse.builder()
                .error((code==Codes.SUCCESS_UPDATE)?null: ErrorResponse.builder().code(code).message(Messages.COMMON_ERROR_ID).build())
                .data((code==Codes.SUCCESS_UPDATE)?true: null).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse> findRestaurantById(@PathVariable Long id) throws Exception{
        Restaurants restaurants = restaurantService.findRestaurantById(id);
        return ResponseEntity.ok(GlobalResponse.builder()
                .error(restaurants!=null?null:ErrorResponse.builder().code(Codes.COMMON_ERR_ID_001).message(Messages.COMMON_ERROR_ID).build())
                .data(restaurants!=null?restaurants:null)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponse> deleteRestaurantById(@PathVariable Long id) throws Exception{
        String code = restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok(GlobalResponse.builder()
                .error((code==Codes.SUCCESS_DELETE)?null: ErrorResponse.builder().code(code).message(Messages.COMMON_ERROR_ID).build())
                .data((code==Codes.SUCCESS_DELETE)?true: null).build());
    }

    @GetMapping("/{id}/personals")
    public ResponseEntity<GlobalResponse> findPersonalsByRestaurant(@PathVariable Long id)  throws Exception{
        RestaurantPersonalsResponse response = restaurantService.getPersonalsByRestaurantId(id);
        return ResponseEntity.ok(GlobalResponse.builder()
                .error(Objects.isNull(response)?ErrorResponse.builder().code(Codes.COMMON_ERR_ID_001).message(Messages.COMMON_ERROR_ID).build():null)
                .data(response).build());
    }
}
