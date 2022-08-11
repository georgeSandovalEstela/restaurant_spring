package com.dev.restaurants.service;


import com.dev.restaurants.domain.Persons;
import com.dev.restaurants.dto.request.PersonsSaveRequest;

public interface PersonsService {
    String savePersons(PersonsSaveRequest personsSaveRequest)throws Exception;
    Persons findPersonsByDocumentNumber(String documentNumber)throws Exception;
}