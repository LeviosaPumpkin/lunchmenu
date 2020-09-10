package leviosa.pumpkin.orderservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.domain.Order;
import leviosa.pumpkin.orderservice.repository.MealRepository;
import leviosa.pumpkin.orderservice.service.MealOrderService;
import leviosa.pumpkin.orderservice.service.OrderService;

@Service
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MealOrderService mealOrderService;
    @Autowired
    private MealRepository mealRepository;

    @Override
    @Transactional
    public void createOrder(int restaurantId, int employeeId, Date date, Map<String, Integer> mealIdAmountMap) {
        float orderCost = 0.0f;
    
        Map<Integer, Float> costs = new HashMap<>();
        for (Map.Entry<String, Integer> mealIdAmount : mealIdAmountMap.entrySet()) {
            float price = mealRepository.findById(Integer.parseInt(mealIdAmount.getKey())).get().getPrice();
            float cost = price * mealIdAmount.getValue();
            costs.put(Integer.parseInt(mealIdAmount.getKey()), price);
            orderCost += cost;
        }

        int orderId = orderService.create(new Order (employeeId, restaurantId, date, orderCost));

        for (Map.Entry<String, Integer> mealIdAmount : mealIdAmountMap.entrySet()) {
            int mealId = Integer.parseInt(mealIdAmount.getKey());
            int amount = mealIdAmount.getValue();
            float cost = costs.get(mealId);
            MealOrder mealOrder = new MealOrder(orderId, mealId, amount, cost);
            mealOrderService.create(mealOrder);
        }
    }
}