package com.dev.restaurants.dto.request;

import com.dev.restaurants.domain.Restaurants;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
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
