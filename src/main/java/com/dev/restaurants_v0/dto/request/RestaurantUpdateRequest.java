package com.dev.restaurants_v0.dto.request;

import com.dev.restaurants_v0.domain.Restaurants;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantUpdateRequest {
    private String ruc;
    private String name;
    private String description;
    private String address;

    public Restaurants castModel(){
        return Restaurants.builder().ruc(ruc).name(name).description(description).address(address).build();
    }
}
