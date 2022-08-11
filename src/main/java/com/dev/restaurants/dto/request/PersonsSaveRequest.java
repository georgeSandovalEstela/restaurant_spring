package com.dev.restaurants.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonsSaveRequest {
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
