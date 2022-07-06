package com.dev.restaurants_v0.controller;

import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.base.ErrorResponse;
import com.dev.restaurants_v0.dto.base.GlobalResponse;
import com.dev.restaurants_v0.dto.request.RestaurantRequest;
import com.dev.restaurants_v0.dto.request.RestaurantUpdateRequest;
import com.dev.restaurants_v0.service.RestaurantService;
import com.dev.restaurants_v0.utils.Codes;
import com.dev.restaurants_v0.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<GlobalResponse> saveRestaurants(@RequestBody RestaurantRequest restaurantRequest) throws Exception {
        String code = restaurantService.saveRestaurant(restaurantRequest);
        return ResponseEntity.ok(GlobalResponse.builder()
                                .error((code==Codes.SUCCESS_SAVE)?null: ErrorResponse.builder().code(code).message(Messages.RESTAURANT_ERROR_NAME).build())
                                .data((code==Codes.SUCCESS_SAVE)?true: null).build());
    }

    @PutMapping("/update")
    public ResponseEntity<GlobalResponse> updateRestaurants(@RequestBody RestaurantUpdateRequest restaurantUpdateRequest) throws Exception{
        String code = restaurantService.updateRestaurant(restaurantUpdateRequest);
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
        return ResponseEntity.ok(GlobalResponse.builder()
                .data(null).build());
    }
}
