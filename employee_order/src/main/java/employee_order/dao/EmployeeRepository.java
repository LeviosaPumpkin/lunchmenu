package employee_order.dao;

import employee_order.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    //void updateBalance(int id, float newBalance);
}
