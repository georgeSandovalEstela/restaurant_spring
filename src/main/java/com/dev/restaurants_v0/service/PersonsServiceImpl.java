package com.dev.restaurants_v0.service;

import com.dev.restaurants_v0.domain.DocumentsTypes;
import com.dev.restaurants_v0.domain.Persons;
import com.dev.restaurants_v0.dto.request.PersonsSaveRequest;
import com.dev.restaurants_v0.repository.PersonsRespository;
import com.dev.restaurants_v0.utils.Codes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PersonsServiceImpl implements PersonsService {
    private final PersonsRespository personsRespository;


    @Override
    public String savePersons(PersonsSaveRequest personsSaveRequest) throws Exception {
        Object personSearch =  personsRespository.findPersonsByDocumentNumber(personsSaveRequest.getDocumentNumber());
        if(personSearch!=null) return Codes.PERSONS_ERROR_DOCUMENT;
        personsRespository.save(Persons.builder()
            .name(personsSaveRequest.getName())
            .lastname(personsSaveRequest.getLastname())
            .fullname(personsSaveRequest.getName()+" "+ personsSaveRequest.getLastname())
            .documentsTypes(DocumentsTypes.builder().id(personsSaveRequest.getDocumentsTypeId()).build())
            .documentNumber(personsSaveRequest.getDocumentNumber())
            .birthday(personsSaveRequest.getBirthday())
            .email(personsSaveRequest.getEmail())
            .sex(personsSaveRequest.getSex())
            .address(personsSaveRequest.getAddress())
            .country(personsSaveRequest.getCountry())
            .city(personsSaveRequest.getCity())
            .createdAt(new Date())
            .build());
        return Codes.SUCCESS_SAVE;
    }

    @Override
    public Persons findPersonsByDocumentNumber(String documentNumber) throws Exception{
        return personsRespository.findPersonsByDocumentNumber(documentNumber);
    }
}
