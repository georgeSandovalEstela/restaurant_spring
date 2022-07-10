package com.dev.restaurants_v0.repository;

import com.dev.restaurants_v0.domain.Personals;
import com.dev.restaurants_v0.dto.response.Restaurants.PersonalsRestaurantsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonalsRespository extends JpaRepository<Personals, Long> {

    @Query(value = "SELECT new com.dev.restaurants_v0.dto.response.Restaurants.PersonalsRestaurantsResponse(per.id,per.persons.fullname,per.persons.sex,per.personalsTypes.name) " +
            "FROM Personals per " +
            "WHERE per.restaurants.id=:restaurantId")
    List<PersonalsRestaurantsResponse> getPersonalsByRestaurantsId(@Param("restaurantId")Long restaurantId) throws Exception;
}
