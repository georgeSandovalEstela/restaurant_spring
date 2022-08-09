package com.dev.restaurants_v0.dto.request;

import com.dev.restaurants_v0.domain.Restaurants;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RestaurantsSaveRequest {

    private String ruc;
    private String name;
    private String description;
    private String address;

    public Restaurants castModel(){
        return Restaurants.builder().ruc(ruc).name(name).description(description).address(address).createdAt(new Date()).updatedAt(new Date()).state(1).build();
    }
}
