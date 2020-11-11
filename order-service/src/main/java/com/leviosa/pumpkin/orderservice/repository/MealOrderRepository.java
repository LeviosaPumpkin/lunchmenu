package com.leviosa.pumpkin.orderservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leviosa.pumpkin.orderservice.domain.MealOrder;

@Repository
public interface MealOrderRepository extends CrudRepository<MealOrder, Integer>{
    List<MealOrder> findByOrderId(int orderId);
}