package com.dev.restaurants_v0.repository;

import com.dev.restaurants_v0.domain.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {
}
