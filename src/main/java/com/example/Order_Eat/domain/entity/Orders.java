package com.example.Order_Eat.domain.entity;

import com.example.Order_Eat.common.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String note;
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ShipperId", referencedColumnName = "id")
    Shipper shipper;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "StoreId", referencedColumnName = "id")
    Store store;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId", referencedColumnName = "id")
    User user;
}
