package com.dev.restaurants_v0.controller;

import com.dev.restaurants_v0.dto.base.GlobalResponse;
import com.dev.restaurants_v0.dto.request.PersonalsSaveRequest;
import com.dev.restaurants_v0.dto.request.PersonsSaveRequest;
import com.dev.restaurants_v0.service.PersonalsService;
import com.dev.restaurants_v0.utils.Codes;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonalsControllerTest {
    @InjectMocks
    PersonalsController personalsController;

    @Mock
    PersonalsService personalsService;

    @Test
    public void savePersonals_SUCCESS_SAVE()throws Exception{
        PersonalsSaveRequest request = new PersonalsSaveRequest(100L,100L,new Date(),new Date(),new Date(),null, new PersonsSaveRequest());
        when(personalsService.savePersonals(request)).thenReturn(Codes.SUCCESS_SAVE);
        ResponseEntity<GlobalResponse> response = personalsController.savePersonals(request);
        assertTrue((Boolean) response.getBody().getData());
    }

    @Test
    public void savePersonals_ERROR_DOCUMENT()throws Exception{
        PersonalsSaveRequest request = new PersonalsSaveRequest(100L,100L,new Date(),new Date(),new Date(),null, new PersonsSaveRequest());
        when(personalsService.savePersonals(request)).thenReturn(Codes.PERSONS_ERROR_DOCUMENT);
        ResponseEntity<GlobalResponse> response = personalsController.savePersonals(request);
        assertEquals(Codes.PERSONS_ERROR_DOCUMENT, response.getBody().getError().getCode());
    }
}
