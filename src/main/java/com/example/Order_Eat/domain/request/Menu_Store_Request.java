package com.example.Order_Eat.domain.request;

import com.example.Order_Eat.domain.entity.Store;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu_Store_Request {
    private String name;
    private String price;
}
