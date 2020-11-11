package com.leviosa.pumpkin.orderservice.repository;

import com.leviosa.pumpkin.orderservice.domain.Order;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByEmployeeId(int employeeId);
    @Query(value = "SELECT * FROM `order` WHERE employee_id = :id AND date BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
    List<Order> findByEmployeeIdAndDateBetween(@Param("id") int employeeId, @Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo);
}
