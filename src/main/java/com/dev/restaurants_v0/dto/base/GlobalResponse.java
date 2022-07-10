package com.dev.restaurants_v0.dto.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GlobalResponse {
    private ErrorResponse error;
    private Object data;
}
