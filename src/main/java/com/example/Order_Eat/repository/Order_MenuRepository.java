package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Order_Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Order_MenuRepository extends JpaRepository<Order_Menu, Long> {
}
