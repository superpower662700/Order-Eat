package com.example.Order_Eat.controller;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.request.Menu_Store_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.service.MenuStoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
@AllArgsConstructor
public class StoreController {
    @Autowired
    MenuStoreService menuStoreService;

    @PostMapping("menu/{id}")
    public boolean addMenu(@PathVariable int id, @RequestBody Menu_Store_Request menu) {
        boolean check = menuStoreService.addMenu(id,menu);
        return check;
    }
    @GetMapping("menu/{id}")
    public ApiResponse addMenu(@PathVariable int id) {
        ApiResponse apiResponse = menuStoreService.getMenu(id);
        return apiResponse;
    }
}
