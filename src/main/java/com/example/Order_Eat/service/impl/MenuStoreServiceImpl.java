package com.example.Order_Eat.service.impl;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.entity.Store;
import com.example.Order_Eat.domain.request.Menu_Store_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.repository.MenuRepository;
import com.example.Order_Eat.repository.StoreRepository;
import com.example.Order_Eat.service.MenuStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuStoreServiceImpl implements MenuStoreService {
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    @Override
    public boolean addMenu(int id, Menu_Store_Request menu) {
        System.out.println( id + " " + menu.getName() + " " + menu.getPrice());
        Store store = storeRepository.findById(id).get();
        System.out.println("store = " + store);
        Menu m = new Menu();
        m.setName(menu.getName());
        m.setPrice(menu.getPrice());
        m.setStore(store);
        menuRepository.save(m);
        return false;
    }

    @Override
    public ApiResponse getMenu(int id) {
        Store store = storeRepository.findById(id).get();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(menuRepository.findByStore(store));
        return apiResponse;
    }
}
