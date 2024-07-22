package com.example.Order_Eat.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order_Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MenuId", referencedColumnName = "id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OrderId", referencedColumnName = "id")
    private Orders order_eat;
}
