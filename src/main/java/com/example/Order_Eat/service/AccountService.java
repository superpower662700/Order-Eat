package com.example.Order_Eat.service;

import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.request.Account_Request;
import com.example.Order_Eat.domain.request.Account_Shipper_Request;
import com.example.Order_Eat.domain.request.Account_Store_Request;
import com.example.Order_Eat.domain.request.Account_User_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    boolean addAccountUser(Account_User_Request account);
    boolean addAccountStore(Account_Store_Request account);
    boolean addAccountShipper(Account_Shipper_Request account);
    ApiResponse loginAccount(Account_Request account);
}
