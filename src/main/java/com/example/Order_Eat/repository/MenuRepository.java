package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByStore(Store store);
}
