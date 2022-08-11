package com.dev.restaurants.dto.response.Restaurants;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class RestaurantPersonalsResponse {
    private List<PersonalsRestaurantsResponse> personals;
}
