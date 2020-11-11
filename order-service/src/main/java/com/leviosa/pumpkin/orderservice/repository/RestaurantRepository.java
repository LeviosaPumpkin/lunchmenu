package com.leviosa.pumpkin.orderservice.repository;

import com.leviosa.pumpkin.orderservice.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    
}
