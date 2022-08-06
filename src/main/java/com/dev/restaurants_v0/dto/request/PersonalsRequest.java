package com.dev.restaurants_v0.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PersonalsRequest {

    private Long restaurantId;
    private Long personalsTypesId;
    private Date salaryDate;
    private Date contractAt;
    private Date finalContractAt;
    private Date renovationContractAt;
    private PersonRequest person;
}
