package com.example.Order_Eat.domain.response;

import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store_Response {

    private int id;
    private String name;
    private String phone;
    private String address;
    public Store_Response(Store store){
        this.id = store.getId();
        this.name = store.getName();
        this.phone = store.getPhone();
        this.address = store.getAddress();
    }
}
