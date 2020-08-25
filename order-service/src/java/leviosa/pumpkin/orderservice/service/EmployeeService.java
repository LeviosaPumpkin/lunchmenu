package leviosa.pumpkin.orderservice.service;

import leviosa.pumpkin.orderservice.domain.Employee;
import org.springframework.stereotype.Component;

public interface EmployeeService {
    void create(String name, float balance);
    void updateBalance(int id, float newBalance);
    Employee get(int id);
    void delete(int id);
}
