package leviosa.pumpkin.orderservice.service;

import leviosa.pumpkin.orderservice.domain.Order;

public interface OrderService {
    int create(Order order);
    void update();
    void delete();
}
