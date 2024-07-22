package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.entity.Shipper;
import com.example.Order_Eat.domain.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findByAccount(Account account);
}
