package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.Personals;
import com.dev.restaurants_v0.domain.PersonalsTypes;
import com.dev.restaurants_v0.domain.Persons;
import com.dev.restaurants_v0.domain.Restaurants;
import com.dev.restaurants_v0.dto.request.PersonalsSaveRequest;
import com.dev.restaurants_v0.dto.response.Personals.PersonalsResponse;
import com.dev.restaurants_v0.repository.PersonalsRespository;
import com.dev.restaurants_v0.utils.Codes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PersonalsServiceImpl implements PersonalsService {
    private final PersonsService personsService;
    private final PersonalsRespository personalsRespository;

    @Override
    public String savePersonals(PersonalsSaveRequest personalsSaveRequest) throws Exception {
        String savePersonCode = personsService.savePersons(personalsSaveRequest.getPerson());
        if(savePersonCode.equals(Codes.PERSONS_ERROR_DOCUMENT)) return savePersonCode;
        Persons personSearch =  personsService.findPersonsByDocumentNumber(personalsSaveRequest.getPerson().getDocumentNumber());
        personalsRespository.save(Personals.builder()
                 .persons(personSearch)
                .salaryDate(personalsSaveRequest.getSalaryDate())
                .contractAt(personalsSaveRequest.getContractAt())
                .finalContractAt(personalsSaveRequest.getFinalContractAt())
                .renovationContractAt(personalsSaveRequest.getRenovationContractAt())
                .createdAt(new Date())
                .restaurants(Restaurants.builder().id(personalsSaveRequest.getRestaurantId()).build())
                .personalsTypes(PersonalsTypes.builder().id(personalsSaveRequest.getPersonalsTypesId()).build())
                .build());
        return Codes.SUCCESS_SAVE;
    }

    @Override
    public PersonalsResponse findPersonalsById(Long id) throws Exception {
        Personals personals = personalsRespository.getReferenceById(id);
        return Objects.isNull(personals) ? null : PersonalsResponse.personalsToResponse(personals);
    }

    @Override
    public PersonalsResponse findPersonalsByDocumentNumber(String documentNumber) throws Exception {
        Personals personals = personalsRespository.findPersonalsByPersons_DocumentNumber(documentNumber);
        return Objects.isNull(personals) ? null : PersonalsResponse.personalsToResponse(personals);
    }
}
