package com.dev.restaurants_v0.repository;


import com.dev.restaurants_v0.domain.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonsRespository extends JpaRepository<Persons, Long> {
}
