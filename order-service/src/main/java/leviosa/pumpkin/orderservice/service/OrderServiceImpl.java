package leviosa.pumpkin.orderservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import leviosa.pumpkin.orderservice.dao.OrderRepository;
import leviosa.pumpkin.orderservice.domain.MealOrder;
import leviosa.pumpkin.orderservice.domain.Order;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void create(Order order) {
        orderRepository.save(order);

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