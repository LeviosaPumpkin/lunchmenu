package leviosa.pumpkin.orderservice.dao;

import leviosa.pumpkin.orderservice.domain.Meal;
import org.springframework.data.repository.CrudRepository;


public interface MealRepository extends CrudRepository<Meal, Integer> {
}
