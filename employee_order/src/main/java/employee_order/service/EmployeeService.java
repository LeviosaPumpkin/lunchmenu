package employee_order.service;

import employee_order.domain.Employee;
import org.springframework.stereotype.Component;

public interface EmployeeService {
    void create(String name, float balance);
    void updateBalance(int id, float newBalance);
    Employee get(int id);
    void delete(int id);
}
