package com.example.Order_Eat.domain.response;

import com.example.Order_Eat.common.Status;
import com.example.Order_Eat.domain.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order_Response {
    private int id;
    private String note;
    private Status status;
    Shipper_Response shipper;
    Store_Response store;
    User_Response user;
    List<Menu_Response> menus = new ArrayList<>();

    public Order_Response(Orders order) {
        this.id = order.getId();
        this.note = order.getNote();
        this.status = order.getStatus();
        this.shipper = new Shipper_Response(order.getShipper());
        this.user = new User_Response(order.getUser());
        this.store = new Store_Response(order.getStore());
    }
    public Order_Response(Orders order, List<Menu> menus) {
        this.id = order.getId();
        this.note = order.getNote();
        this.status = order.getStatus();
        this.shipper = new Shipper_Response(order.getShipper());
        this.user = new User_Response(order.getUser());
        this.store = new Store_Response(order.getStore());
        menus.forEach(menu -> this.menus.add(new Menu_Response(menu)));
    }
}
