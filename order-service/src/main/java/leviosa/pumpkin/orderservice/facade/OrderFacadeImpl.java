package leviosa.pumpkin.orderservice.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.domain.Order;
import leviosa.pumpkin.orderservice.service.MealOrderService;
import leviosa.pumpkin.orderservice.service.OrderService;

public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private OrderService orderService;
    @Autowired
    private MealOrderService mealOrderService;

    @Override
    @Transactional
    public void createOrder(Order order, List<MealOrder> mealOrders) {
        orderService.create(order);   
        mealOrders.forEach(mo -> mealOrderService.create(mo));
    }
    
}