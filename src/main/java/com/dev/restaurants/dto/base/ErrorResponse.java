package com.dev.restaurants.dto.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {
    private String code;
    private String message;
}
