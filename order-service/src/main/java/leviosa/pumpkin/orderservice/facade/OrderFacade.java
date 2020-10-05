package leviosa.pumpkin.orderservice.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import leviosa.pumpkin.orderservice.controllers.dto.GetOrdersResponseDto;


public interface OrderFacade {
    void createOrder(int restaurantId, int employeeId, Date date, Map<String, Integer> mealIdAmountMap);
    List<GetOrdersResponseDto> getOrders(int employeeId);
}