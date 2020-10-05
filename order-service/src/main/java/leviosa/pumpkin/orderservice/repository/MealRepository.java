package leviosa.pumpkin.orderservice.repository;

import leviosa.pumpkin.orderservice.domain.Meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
}
