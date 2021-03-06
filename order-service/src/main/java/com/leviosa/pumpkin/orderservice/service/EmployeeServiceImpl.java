package com.leviosa.pumpkin.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leviosa.pumpkin.orderservice.domain.Employee;
import com.leviosa.pumpkin.orderservice.repository.EmployeeRepository;

@Service
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
