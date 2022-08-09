package com.dev.restaurants_v0.service;


import com.dev.restaurants_v0.domain.Persons;
import com.dev.restaurants_v0.dto.request.PersonsSaveRequest;

public interface PersonsService {
    String savePersons(PersonsSaveRequest personsSaveRequest)throws Exception;
    Persons findPersonsByDocumentNumber(String documentNumber)throws Exception;
}