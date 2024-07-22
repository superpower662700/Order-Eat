package com.example.Order_Eat.repository;
import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.entity.Shipper;
import com.example.Order_Eat.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByAccount(Account account);
}
