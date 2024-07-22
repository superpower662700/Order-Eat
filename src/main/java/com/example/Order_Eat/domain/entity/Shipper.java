package com.example.Order_Eat.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AccountId", referencedColumnName = "id")
    private Account account;
}
