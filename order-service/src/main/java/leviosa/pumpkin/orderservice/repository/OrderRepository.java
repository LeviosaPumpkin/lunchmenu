package leviosa.pumpkin.orderservice.repository;

import leviosa.pumpkin.orderservice.domain.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByEmployeeId(int employeeId);
}
