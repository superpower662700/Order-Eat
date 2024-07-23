package com.example.Order_Eat.domain.response;

import com.example.Order_Eat.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User_Response {
    private int id;
    private String name;
    private String phone;
    private String address;

    public User_Response(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.address = user.getAddress();
    }
}
