package leviosa.pumpkin.orderservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import leviosa.pumpkin.orderservice.domain.MealOrder;

@Repository
public interface MealOrderRepository extends CrudRepository<MealOrder, Integer>{
    
}