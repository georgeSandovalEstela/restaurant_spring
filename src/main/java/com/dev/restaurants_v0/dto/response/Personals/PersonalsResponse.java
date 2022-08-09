package com.dev.restaurants_v0.dto.response.Personals;

import com.dev.restaurants_v0.domain.Personals;
import com.dev.restaurants_v0.dto.response.PersonsResponse.PersonsResponse;
import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonalsResponse {
    private Long id;
    private String personalsType;
    private Date salaryDate;
    private Date contractAt;
    private Date renovationContractAt;
    private Date finalContractAt;
    private String restaurantName;
    private PersonsResponse personsResponse;

    public static PersonalsResponse personalsToResponse(Personals personals){
        return PersonalsResponse.builder()
                .id(personals.getId())
                .personalsType(personals.getPersonalsTypes().getName())
                .salaryDate(personals.getSalaryDate())
                .contractAt(personals.getContractAt())
                .renovationContractAt(personals.getRenovationContractAt())
                .finalContractAt(personals.getFinalContractAt())
                .restaurantName(personals.getRestaurants().getName())
                .personsResponse(PersonsResponse.personsToPersonsResponse(personals.getPersons()))
                .build();
    }
}
