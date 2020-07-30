package employee_order.dao;

import employee_order.domain.Meal;
import org.springframework.data.repository.CrudRepository;


public interface MealRepository extends CrudRepository<Meal, Integer> {
}
