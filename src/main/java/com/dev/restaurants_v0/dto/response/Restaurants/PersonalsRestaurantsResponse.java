package com.dev.restaurants_v0.dto.response.Restaurants;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class PersonalsRestaurantsResponse {
    private Long id;
    private String fullname;
    private String sex;
    private String personalType;
}
