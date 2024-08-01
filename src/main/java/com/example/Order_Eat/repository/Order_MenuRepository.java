package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.entity.Order_Menu;
import com.example.Order_Eat.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Order_MenuRepository extends JpaRepository<Order_Menu, Integer> {

    @Query("SELECT m FROM Order_Menu u JOIN u.menu m WHERE u.orders = :orders")
    List<Menu> findByOrders(@Param("orders") Orders orders);
}
