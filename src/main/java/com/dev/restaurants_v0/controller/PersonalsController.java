package com.dev.restaurants_v0.controller;

import com.dev.restaurants_v0.dto.base.ErrorResponse;
import com.dev.restaurants_v0.dto.base.GlobalResponse;
import com.dev.restaurants_v0.dto.request.PersonalsSaveRequest;
import com.dev.restaurants_v0.dto.response.Personals.PersonalsResponse;
import com.dev.restaurants_v0.service.PersonalsService;
import com.dev.restaurants_v0.utils.Codes;
import com.dev.restaurants_v0.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/v1/personals")
@RequiredArgsConstructor
@CrossOrigin
public class PersonalsController {

    public final PersonalsService personalsService;


    @PostMapping("/save")
    public ResponseEntity<GlobalResponse> savePersonals(@RequestBody PersonalsSaveRequest personalsSaveRequest) throws Exception {
        String code = personalsService.savePersonals(personalsSaveRequest);
        return ResponseEntity.ok(GlobalResponse.builder()
                .error((code.equals(Codes.SUCCESS_SAVE)) ? null : ErrorResponse.builder()
                        .code(code)
                        .message(Messages.PERSONS_ERROR_DOCUMENT).build())
                .data((code.equals(Codes.SUCCESS_SAVE)) ? true : null).build());
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<GlobalResponse> findPersonalsByDocumentNumber(@PathVariable String documentNumber) throws Exception{
        PersonalsResponse personalsResponse = personalsService.findPersonalsByDocumentNumber(documentNumber);
        return ResponseEntity.ok(GlobalResponse
                .builder()
                .data(personalsResponse).build());
    }

    @GetMapping("/")
    public ResponseEntity<GlobalResponse> findPersonalsById(@RequestParam(value = "id", required = true) Long id) throws Exception{
        PersonalsResponse personalsResponse = personalsService.findPersonalsById(id);
        return ResponseEntity.ok(GlobalResponse
                .builder()
                .data(personalsResponse).build());
    }
}
