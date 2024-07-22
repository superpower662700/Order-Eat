package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
