package com.dev.restaurants.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RestaurantsUpdateRequest {
    private Long id;
    private String ruc;
    private String name;
    private String description;
    private String address;
}
