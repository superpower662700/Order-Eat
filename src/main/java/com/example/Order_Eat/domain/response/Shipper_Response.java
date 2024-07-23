package com.example.Order_Eat.domain.response;

import com.example.Order_Eat.domain.entity.Shipper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipper_Response {

    private int id;
    private String name;
    private String phone;

    public Shipper_Response(Shipper shipper) {
        this.id = shipper.getId();
        this.name = shipper.getName();
        this.phone = shipper.getPhone();
    }
}
