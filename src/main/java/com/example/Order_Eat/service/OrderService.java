package com.example.Order_Eat.service;

import com.example.Order_Eat.common.Status;
import com.example.Order_Eat.domain.request.Order_Request;
import com.example.Order_Eat.domain.request.StatusRequest;
import com.example.Order_Eat.domain.response.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    boolean addOrder(Order_Request order);
    boolean updateOrder(Order_Request order);
    boolean changeStatus(int id, StatusRequest status);
    ApiResponse getOrderByStatus(StatusRequest status);
    ApiResponse getOrderByStatusOfStore(StatusRequest status, int id);
    ApiResponse getOrderByStatusOfShipper(StatusRequest status, int id);
    ApiResponse getOrderOfUser(int id);
}
