package com.dev.restaurants.repository;

import com.dev.restaurants.domain.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Long> {

    @Query(value = "SELECT COUNT(rest.id) FROM Restaurants rest  WHERE rest.state=1 AND rest.name=:name")
    Long findByName(@Param("name") String name) throws Exception;

    //@Query("SELECT rest FROM Restaurants rest where rest.id=:id and rest.state<>:state")
    Optional<Restaurants> findByIdAndState(Long id, Integer state);

    @Query(value = "UPDATE Restaurants rest SET rest.state=:stateInactive WHERE rest.id=:id")
    Restaurants deleteById(@Param("id")Long id, @Param("stateInactive")Integer stateInactive)throws Exception;

    List<Restaurants> findALlByState(Integer state);
    /*
    * @Query(value = "SELECT new com.smart.business.administration.dto.response.ViewFeatureDto(" +
            "vf.id, vf.name, vf.description,vf.featureValues) FROM ViewFeature vf " +
            "WHERE upper(vf.name) LIKE UPPER(:filter) OR upper(vf.description) LIKE UPPER(:filter)")
    * */

}
