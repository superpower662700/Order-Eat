package com.example.Order_Eat.controller;

import com.example.Order_Eat.domain.request.Menu_Store_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
@AllArgsConstructor
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping()
    public ApiResponse Stores() {
        ApiResponse apiResponse = storeService.getStores();
        return apiResponse;
    }

    @PostMapping("menu/{id}")
    public boolean addMenu(@PathVariable int id, @RequestBody Menu_Store_Request menu) {
        boolean check = storeService.addMenu(id,menu);
        return check;
    }
    @GetMapping("menu/{id}")
    public ApiResponse Menus(@PathVariable int id) {
        ApiResponse apiResponse = storeService.getMenu(id);
        return apiResponse;
    }
}
