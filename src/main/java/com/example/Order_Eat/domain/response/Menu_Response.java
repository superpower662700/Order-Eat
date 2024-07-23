package com.example.Order_Eat.domain.response;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.entity.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Menu_Response {
    private int id;
    private String name;
    private String price;
    public Menu_Response(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.price = menu.getPrice();
    }
}
