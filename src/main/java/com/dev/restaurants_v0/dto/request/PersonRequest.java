package com.dev.restaurants_v0.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PersonRequest {
    private String name;
    private String lastname;
    private Long documentsTypeId;
    private String documentNumber;
    private Date birthday;
    private String email;
    private String sex;
    private String address;
    private String country;
    private String city;
}
