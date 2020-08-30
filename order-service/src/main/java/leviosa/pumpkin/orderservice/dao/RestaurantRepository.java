package leviosa.pumpkin.orderservice.dao;

import leviosa.pumpkin.orderservice.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
    
}
