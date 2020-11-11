package com.leviosa.pumpkin.orderservice.service;

import com.leviosa.pumpkin.orderservice.domain.Employee;

public interface EmployeeService {
    void create(String name, float balance);
    void updateBalance(int id, float newBalance);
    Employee get(int id);
    void delete(int id);
}
