package com.leviosa.pumpkin.orderservice.repository;

import com.leviosa.pumpkin.orderservice.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
