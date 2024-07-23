package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Order_Menu;
import com.example.Order_Eat.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Order_MenuRepository extends JpaRepository<Order_Menu, Integer> {
    List<Order_Menu> findByOrders(Orders orders);
}
