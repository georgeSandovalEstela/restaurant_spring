package com.dev.restaurants_v0.dto.response.PersonsResponse;

import com.dev.restaurants_v0.domain.Persons;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class PersonsResponse {
    private Long id;
    private String name;
    private String lastname;
    private String fullName;
    private String documentType;
    private String documentNumber;
    private Date birthday;
    private String email;
    private String sex;
    private String address;
    private String country;
    private String city;

    public static PersonsResponse personsToPersonsResponse(Persons persons){
        return PersonsResponse.builder()
                .id(persons.getId())
                .name(persons.getName())
                .lastname(persons.getLastname())
                .fullName(persons.getFullname())
                .documentType(persons.getDocumentsTypes().getShortname())
                .documentNumber(persons.getDocumentNumber())
                .birthday(persons.getBirthday())
                .email(persons.getEmail())
                .sex(persons.getSex())
                .address(persons.getAddress())
                .country(persons.getCountry())
                .city(persons.getCity())
                .build();
    }
}
