package com.example.Order_Eat.domain.request;

import com.example.Order_Eat.common.Status;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Order_Request {
    private int id;
    private String note;
    private Status status;
    private int id_user;
    private int id_shipper;
    private int id_store;
    private List<Integer> list_eat;
}
