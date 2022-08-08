package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.DocumentsTypes;
import com.dev.restaurants_v0.domain.Personals;
import com.dev.restaurants_v0.domain.Persons;
import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.PersonalsSaveRequest;
import com.dev.restaurants_v0.repository.PersonalsRespository;
import com.dev.restaurants_v0.repository.PersonsRespository;
import com.dev.restaurants_v0.utils.Codes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersonalsServiceImpl implements PersonalsService {
    private final PersonsRespository personsRespository;
    private final PersonalsRespository personalsRespository;


    @Override
    public String savePersonals(PersonalsSaveRequest personalsSaveRequest) throws Exception {
        Persons personSearch =  personsRespository.findPersonsByDocumentNumber("74901792");
        if(personSearch!=null) return Codes.PERSONS_ERROR_DOCUMENT;
        personSearch = personsRespository.save(Persons.builder()
                .name(personalsSaveRequest.getPerson().getName())
                .lastname(personalsSaveRequest.getPerson().getLastname())
                .fullname(personalsSaveRequest.getPerson().getName()+" "+ personalsSaveRequest.getPerson().getLastname())
                .documentsTypes(DocumentsTypes.builder().id(personalsSaveRequest.getPerson().getDocumentsTypeId()).build())
                .documentNumber(personalsSaveRequest.getPerson().getDocumentNumber())
                .birthday(personalsSaveRequest.getPerson().getBirthday())
                .email(personalsSaveRequest.getPerson().getEmail())
                .sex(personalsSaveRequest.getPerson().getSex())
                .address(personalsSaveRequest.getPerson().getAddress())
                .country(personalsSaveRequest.getPerson().getCountry())
                .city(personalsSaveRequest.getPerson().getCity())
                .createdAt(new Date())
                .build());
        personalsRespository.save(Personals.builder()
                .persons(personSearch)
                .salaryDate(personalsSaveRequest.getSalaryDate())
                .contractAt(personalsSaveRequest.getContractAt())
                .restaurants(Restaurants.builder().id(personalsSaveRequest.getRestaurantId()).build())
                .finalContractAt(personalsSaveRequest.getFinalContractAt())
                .renovationContractAt(personalsSaveRequest.getRenovationContractAt())
                .createdAt(new Date())
                .build());
        return Codes.SUCCESS_SAVE;
    }
}
