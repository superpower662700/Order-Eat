package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.entity.Shipper;
import org.springframework.data.repository.CrudRepository;

public interface ShipperRepository extends CrudRepository<Shipper, Integer> {
    Shipper findByAccount(Account account);
    Shipper findById(int id);
}
