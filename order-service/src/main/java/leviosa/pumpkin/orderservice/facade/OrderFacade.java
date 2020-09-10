package leviosa.pumpkin.orderservice.facade;

import java.util.Date;
import java.util.Map;


public interface OrderFacade {
    void createOrder(int restaurantId, int employeeId, Date date, Map<String, Integer> mealIdAmountMap);
}