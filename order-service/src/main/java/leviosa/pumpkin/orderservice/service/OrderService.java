package leviosa.pumpkin.orderservice.service;

import leviosa.pumpkin.orderservice.domain.Order;

public interface OrderService {
    void create(Order order);
    void update();
    void delete();
}
