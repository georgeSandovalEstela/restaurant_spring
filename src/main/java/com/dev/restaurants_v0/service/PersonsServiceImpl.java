package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.DocumentsTypes;
import com.dev.restaurants_v0.domain.Personals;
import com.dev.restaurants_v0.domain.Persons;
import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.PersonalsRequest;
import com.dev.restaurants_v0.repository.PersonalsRespository;
import com.dev.restaurants_v0.repository.PersonsRespository;
import com.dev.restaurants_v0.utils.Codes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersonsServiceImpl implements PersonalsService {
    private final PersonsRespository personsRespository;
    private final PersonalsRespository personalsRespository;


    @Override
    public String savePersonals(PersonalsRequest personalsRequest) throws Exception {
        Persons personSearch =  personsRespository.findPersonsByDocumentNumber("74901792");
        if(personSearch!=null) return Codes.PERSONALS_ERROR_DOCUMENT;
        personSearch = personsRespository.save(Persons.builder()
                .name(personalsRequest.getPerson().getName())
                .lastname(personalsRequest.getPerson().getLastname())
                .fullname(personalsRequest.getPerson().getName()+" "+personalsRequest.getPerson().getLastname())
                .documentsTypes(DocumentsTypes.builder().id(personalsRequest.getPerson().getDocumentsTypeId()).build())
                .documentNumber(personalsRequest.getPerson().getDocumentNumber())
                .birthday(personalsRequest.getPerson().getBirthday())
                .email(personalsRequest.getPerson().getEmail())
                .sex(personalsRequest.getPerson().getSex())
                .address(personalsRequest.getPerson().getAddress())
                .country(personalsRequest.getPerson().getCountry())
                .city(personalsRequest.getPerson().getCity())
                .createdAt(new Date())
                .build());
        return Codes.SUCCESS_SAVE;
    }
}
