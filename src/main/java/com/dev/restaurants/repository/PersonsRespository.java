package com.dev.restaurants.repository;


import com.dev.restaurants.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRespository extends JpaRepository<Persons, Long> {

    Persons findPersonsByDocumentNumber(String documentNumber)throws Exception;
}
