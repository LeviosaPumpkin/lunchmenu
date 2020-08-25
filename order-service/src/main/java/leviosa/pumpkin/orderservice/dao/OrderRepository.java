package leviosa.pumpkin.orderservice.dao;

import leviosa.pumpkin.orderservice.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    
}
