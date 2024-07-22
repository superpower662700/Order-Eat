package com.example.Order_Eat.domain.request;

import com.example.Order_Eat.domain.entity.User;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account_User_Request {
    private String name;
    private String password;
    User user;
}
