package leviosa.pumpkin.orderservice.dao;

import leviosa.pumpkin.orderservice.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
