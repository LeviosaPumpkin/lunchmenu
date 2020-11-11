package com.leviosa.pumpkin.orderservice.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.leviosa.pumpkin.orderservice.controllers.dto.GetOrdersResponseDto;


public interface OrderFacade {
    void createOrder(int restaurantId, int employeeId, Date date, Map<String, Integer> mealIdAmountMap);
    List<GetOrdersResponseDto> getAllOrdersForEmployee(int employeeId);
    List<GetOrdersResponseDto> getOrdersForDates(int employeeId, Date dateFrom, Date dateTo);
}