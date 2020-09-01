package leviosa.pumpkin.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import leviosa.pumpkin.orderservice.dao.MealOrderRepository;
import leviosa.pumpkin.orderservice.domain.MealOrder;

public class MealOrderServiceImpl implements MealOrderService {
    @Autowired
    private MealOrderRepository mealOrderRepository;

    @Override
    public void create(MealOrder mealOrder) {
        mealOrderRepository.save(mealOrder);
    }
    
}