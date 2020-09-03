package leviosa.pumpkin.orderservice.repository;

import leviosa.pumpkin.orderservice.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Integer> {
}