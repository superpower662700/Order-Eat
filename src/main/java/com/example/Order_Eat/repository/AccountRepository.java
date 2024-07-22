package com.example.Order_Eat.repository;

import com.example.Order_Eat.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByName(String name);
}
