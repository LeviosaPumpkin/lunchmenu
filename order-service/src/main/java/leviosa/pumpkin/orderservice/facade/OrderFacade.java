package leviosa.pumpkin.orderservice.facade;

import java.util.List;

import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.domain.Order;

public interface OrderFacade {
    void createOrder(Order order, List<MealOrder> mealOrders);
}