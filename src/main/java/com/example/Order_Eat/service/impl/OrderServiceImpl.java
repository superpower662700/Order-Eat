package com.example.Order_Eat.service.impl;

import com.example.Order_Eat.common.Status;
import com.example.Order_Eat.domain.entity.*;
import com.example.Order_Eat.domain.request.Order_Request;
import com.example.Order_Eat.domain.request.StatusRequest;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.domain.response.Order_Response;
import com.example.Order_Eat.repository.*;
import com.example.Order_Eat.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ShipperRepository shipperRepository;
    private final MenuRepository menuRepository;
    private final Order_MenuRepository orderMenuRepository;

    @Override
    public boolean addOrder(Order_Request order) {
        User user = userRepository.findById(order.getId_user()).orElseThrow();
        Store store = storeRepository.findById(order.getId_store()).orElseThrow();
        Shipper shipper = null;
        if(shipperRepository.findById(order.getId_shipper()) != null){
            shipper = shipperRepository.findById(order.getId_shipper());
        }
        Orders o = new Orders();
        o.setNote(order.getNote());
        o.setStatus(order.getStatus());
        o.setUser(user);
        o.setStore(store);
        o.setShipper(shipper);
        ordersRepository.save(o);

        order.getList_eat().forEach(
                id_eat -> {
                    Menu menu = menuRepository.findById(id_eat).orElseThrow();
                    Order_Menu o_menu = new Order_Menu();
                    o_menu.setMenu(menu);
                    o_menu.setOrders(o);
                    orderMenuRepository.save(o_menu);
                }
        );
        return true;
    }

    @Override
    public boolean updateOrder(Order_Request order) {
        User user = userRepository.findById(order.getId_user()).orElseThrow();
        Store store = storeRepository.findById(order.getId_store()).orElseThrow();
        Shipper shipper = null;
        if(shipperRepository.findById(order.getId_shipper()) != null){
            shipper = shipperRepository.findById(order.getId_shipper());
        }
        Orders o = new Orders();
        o.setId(order.getId());
        o.setNote(order.getNote());
        o.setStatus(order.getStatus());
        o.setUser(user);
        o.setStore(store);
        o.setShipper(shipper);
        ordersRepository.save(o);
        order.getList_eat().forEach(
                id_eat -> {
                    Menu menu = menuRepository.findById(id_eat).orElseThrow();
                    Order_Menu o_menu = new Order_Menu();
                    o_menu.setMenu(menu);
                    o_menu.setOrders(o);
                    orderMenuRepository.save(o_menu);
                }
        );
        return true;
    }

    @Override
    public boolean changeStatus(int id, StatusRequest status) {
        Orders o = ordersRepository.findById(id).orElseThrow();
        o.setStatus(status.getStatus());
        return true;
    }

    @Override
    public ApiResponse getOrderByStatus(StatusRequest status) {
        List<Orders> o = ordersRepository.findByStatus(status.getStatus());
        List<Order_Response> orderResponses = o.stream()
                .map( orders -> {
                    return new Order_Response(orders,
                            orderMenuRepository.findByOrders(orders)
                            );
                })
                .collect(Collectors.toList());
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setResult(orderResponses);
        return apiResponse;
    }

    @Override
    public ApiResponse getOrderByStatusOfStore(StatusRequest status, int id) {
        Store store = storeRepository.findById(id).orElseThrow();
        ApiResponse apiResponse = new ApiResponse();
        List<Orders> o = ordersRepository.findByStatusAndStore(status.getStatus(), store);
        List<Order_Response> orderResponses = o.stream()
                .map( orders -> new Order_Response(orders))
                .collect(Collectors.toList());
        apiResponse.setResult(orderResponses);
        return apiResponse;
    }

    @Override
    public ApiResponse getOrderByStatusOfShipper(StatusRequest status, int id) {
        Shipper shipper = shipperRepository.findById(id);
        ApiResponse apiResponse = new ApiResponse();
        List<Orders> o = ordersRepository.findByStatusAndShipper(status.getStatus(), shipper);
        List<Order_Response> orderResponses = o.stream()
                .map( orders -> new Order_Response(orders))
                .collect(Collectors.toList());
        apiResponse.setResult(orderResponses);
        return apiResponse;
    }

    @Override
    public ApiResponse getOrderOfUser(int id) {
        User user = userRepository.findById(id).orElseThrow();
        ApiResponse apiResponse = new ApiResponse();
        List<Orders> o = ordersRepository.findByUser(user);
        List<Order_Response> orderResponses = o.stream()
                .map( orders -> new Order_Response(orders))
                .collect(Collectors.toList());
        apiResponse.setResult(orderResponses);
        return apiResponse;
    }
}
