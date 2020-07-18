package employee_order.service;

import employee_order.dao.EmployeeRepository;
import employee_order.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository repository;
    
    @Transactional
    public void create(String name, float balance) {
        repository.save(new Employee(name, balance));
    }
    
    @Transactional
    public void updateBalance(int id, float newBalance) {
        Employee employee = repository.findById(id).get();
        if (employee != null) {
            employee.setBalance(newBalance);
            repository.save(employee);   
        }
    }
    
    @Transactional
    public Employee get(int id) {
        return repository.findById(id).orElse(null);
    }
    
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

}
