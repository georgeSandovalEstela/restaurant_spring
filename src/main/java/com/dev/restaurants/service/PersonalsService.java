package com.dev.restaurants.service;

import com.dev.restaurants.dto.request.PersonalsSaveRequest;
import com.dev.restaurants.dto.response.Personals.PersonalsResponse;

public interface PersonalsService {
    String savePersonals(PersonalsSaveRequest personalsSaveRequest)throws Exception;
    PersonalsResponse findPersonalsById(Long id)throws Exception;
    PersonalsResponse findPersonalsByDocumentNumber(String documentNumber)throws Exception;
}