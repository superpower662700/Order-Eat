package com.example.Order_Eat.repository;

import com.example.Order_Eat.common.Status;
import com.example.Order_Eat.domain.entity.Orders;
import com.example.Order_Eat.domain.entity.Shipper;
import com.example.Order_Eat.domain.entity.Store;
import com.example.Order_Eat.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByStatus(Status status);
    List<Orders> findByStatusAndStore(Status status, Store store);
    List<Orders> findByStatusAndShipper(Status status, Shipper shipper);
    List<Orders> findByUser(User user);
}
