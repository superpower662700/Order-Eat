package com.example.Order_Eat.service.impl;

import com.example.Order_Eat.domain.entity.Menu;
import com.example.Order_Eat.domain.entity.Store;
import com.example.Order_Eat.domain.request.Menu_Store_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.domain.response.Menu_Response;
import com.example.Order_Eat.domain.response.Store_Response;
import com.example.Order_Eat.repository.MenuRepository;
import com.example.Order_Eat.repository.StoreRepository;
import com.example.Order_Eat.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    @Override
    public ApiResponse getStores() {
        List<Store> stores = storeRepository.findAll();
        List<Store_Response> store_responses = stores
                .stream()
                .map(store -> new Store_Response(store))
                .collect(Collectors.toList());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(store_responses);
        return apiResponse;
    }

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
        List<Menu> menus = menuRepository.findByStore(store);
        List<Menu_Response> menuResponses = menus.stream().map(menu -> new Menu_Response(menu)).collect(Collectors.toUnmodifiableList());
        apiResponse.setResult(menuResponses);
        return apiResponse;
    }
}
