package com.example.Order_Eat.domain.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.Order_Eat.domain.entity.Store;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account_Store_Request {
    private String name;
    private String password;
    Store store;
}
