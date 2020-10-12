package leviosa.pumpkin.orderservice.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leviosa.pumpkin.orderservice.controllers.dto.GetOrdersResponseDto;
import leviosa.pumpkin.orderservice.domain.Employee;
import leviosa.pumpkin.orderservice.domain.Meal;
import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.domain.Order;
import leviosa.pumpkin.orderservice.repository.EmployeeRepository;
import leviosa.pumpkin.orderservice.repository.MealOrderRepository;
import leviosa.pumpkin.orderservice.repository.MealRepository;
import leviosa.pumpkin.orderservice.repository.OrderRepository;
import leviosa.pumpkin.orderservice.repository.RestaurantRepository;

@Service
public class OrderFacadeImpl implements OrderFacade {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MealOrderRepository mealOrderRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

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

        int orderId = orderRepository.save(new Order (employeeId, restaurantId, date, orderCost)).getId();

        for (Map.Entry<String, Integer> mealIdAmount : mealIdAmountMap.entrySet()) {
            int mealId = Integer.parseInt(mealIdAmount.getKey());
            int amount = mealIdAmount.getValue();
            float cost = costs.get(mealId);
            MealOrder mealOrder = new MealOrder(orderId, mealId, amount, cost);
            mealOrderRepository.save(mealOrder);
        }

        Employee employee = employeeRepository.findById(employeeId).get();
        employee.setBalance(employee.getBalance() - orderCost);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public List<GetOrdersResponseDto> getAllOrdersForEmployee(int employeeId) {
        List<GetOrdersResponseDto> getOrdersResponseDtos = new ArrayList<>();
        orderRepository.findByEmployeeId(employeeId).forEach(o -> {
            mealOrderRepository.findByOrderId(o.getId()).forEach(mo -> {
                GetOrdersResponseDto dto = new GetOrdersResponseDto();
                dto.setDate(o.getDate());
                dto.setRestaurant(restaurantRepository.findById(o.getRestaurantId()).get().getName());
                dto.setAmount(mo.getAmount());
                Meal meal = mealRepository.findById(mo.getMealId()).get();
                dto.setMealName(meal.getName());
                dto.setPrice(meal.getPrice());
                getOrdersResponseDtos.add(dto);
            });
        });
        return getOrdersResponseDtos;
    }

    @Override
    @Transactional
    public List<GetOrdersResponseDto> getOrdersForDates(int employeeId, Date dateFrom, Date dateTo) {
        List<GetOrdersResponseDto> getOrdersResponseDtos = new ArrayList<>();
        orderRepository.findByEmployeeIdAndDateBetween(employeeId, dateFrom, dateTo).forEach(o -> {
            mealOrderRepository.findByOrderId(o.getId()).forEach(mo -> {
                GetOrdersResponseDto dto = new GetOrdersResponseDto();
                dto.setDate(o.getDate());
                dto.setRestaurant(restaurantRepository.findById(o.getRestaurantId()).get().getName());
                dto.setAmount(mo.getAmount());
                Meal meal = mealRepository.findById(mo.getMealId()).get();
                dto.setMealName(meal.getName());
                dto.setPrice(meal.getPrice());
                getOrdersResponseDtos.add(dto);
            });
        });
        return getOrdersResponseDtos;
    }
}