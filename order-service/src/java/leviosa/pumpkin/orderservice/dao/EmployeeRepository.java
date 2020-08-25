package leviosa.pumpkin.orderservice.dao;

import leviosa.pumpkin.orderservice.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
