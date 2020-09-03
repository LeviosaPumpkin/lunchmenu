package leviosa.pumpkin.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.repository.MealOrderRepository;

public class MealOrderServiceImpl implements MealOrderService {
    @Autowired
    private MealOrderRepository mealOrderRepository;

    @Override
    public void create(MealOrder mealOrder) {
        mealOrderRepository.save(mealOrder);
    }
    
}