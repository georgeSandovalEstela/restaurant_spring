package com.dev.restaurants_v0.dto.response.Restaurants;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class PersonalsRestaurantsResponse {
    private Long id;
    private String fullname;
    private String sex;
    private String personalType;
}
