package com.dev.restaurants_v0.dto.request;

import com.dev.restaurants_v0.domain.Restaurants;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantUpdateRequest {
    private Long id;
    private String ruc;
    private String name;
    private String description;
    private String address;
}
