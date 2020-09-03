package leviosa.pumpkin.orderservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.domain.Order;
import leviosa.pumpkin.orderservice.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public int create(Order order) {
        orderRepository.save(order).getId();
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub

    }
    
}