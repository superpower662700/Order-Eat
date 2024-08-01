package com.example.Order_Eat.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private String price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StoreId", referencedColumnName = "id")
    private Store store;
}
