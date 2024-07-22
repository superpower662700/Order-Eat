package com.example.Order_Eat.controller;

import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.request.Account_Request;
import com.example.Order_Eat.domain.request.Account_Shipper_Request;
import com.example.Order_Eat.domain.request.Account_Store_Request;
import com.example.Order_Eat.domain.request.Account_User_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("login")
    public ApiResponse login(@RequestBody Account_Request account){
        ApiResponse check = accountService.loginAccount(account);
        return check;
    }

    @PostMapping("create_user")
    public boolean createUser(@RequestBody Account_User_Request account) {
        boolean check = accountService.addAccountUser(account);
        return check;
    }
    @PostMapping("create_store")
    public boolean createStore(@RequestBody Account_Store_Request account) {
        boolean check = accountService.addAccountStore(account);
        return check;
    }
    @PostMapping("create_shipper")
    public boolean createShipper(@RequestBody Account_Shipper_Request account) {
        boolean check = accountService.addAccountShipper(account);
        return check;
    }
}
