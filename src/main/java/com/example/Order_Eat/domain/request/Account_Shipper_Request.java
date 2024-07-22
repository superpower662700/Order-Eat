package com.example.Order_Eat.domain.request;

import com.example.Order_Eat.domain.entity.Shipper;
import com.example.Order_Eat.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account_Shipper_Request {
    private String name;
    private String password;
    Shipper shipper;
}
