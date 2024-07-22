package com.example.Order_Eat.service;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.request.Menu_Store_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface MenuStoreService {
    boolean addMenu(int id ,Menu_Store_Request menu);
    ApiResponse getMenu(int id);
}
