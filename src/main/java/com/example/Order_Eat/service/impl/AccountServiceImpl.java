package com.example.Order_Eat.service.impl;

import com.example.Order_Eat.domain.entity.Account;
import com.example.Order_Eat.domain.entity.Shipper;
import com.example.Order_Eat.domain.entity.Store;
import com.example.Order_Eat.domain.entity.User;
import com.example.Order_Eat.domain.request.Account_Request;
import com.example.Order_Eat.domain.request.Account_Shipper_Request;
import com.example.Order_Eat.domain.request.Account_Store_Request;
import com.example.Order_Eat.domain.request.Account_User_Request;
import com.example.Order_Eat.domain.response.ApiResponse;
import com.example.Order_Eat.repository.AccountRepository;
import com.example.Order_Eat.repository.ShipperRepository;
import com.example.Order_Eat.repository.StoreRepository;
import com.example.Order_Eat.repository.UserRepository;
import com.example.Order_Eat.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ShipperRepository shipperRepository;

    @Override
    public boolean addAccountUser(Account_User_Request account) {
        Account account1 = new Account();
        account1.setName(account.getName());
        account1.setPassword(account.getPassword());
        accountRepository.save(account1);
        User user = new User();
        user.setAccount(account1);
        user.setName(account.getUser().getName());
        user.setAddress(account.getUser().getAddress());
        user.setPhone(account.getUser().getPhone());
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean addAccountStore(Account_Store_Request account) {
        Account account1 = new Account();
        account1.setName(account.getName());
        account1.setPassword(account.getPassword());
        accountRepository.save(account1);
        Store store = new Store();
        store.setAccount(account1);
        store.setName(account.getStore().getName());
        store.setAddress(account.getStore().getAddress());
        store.setPhone(account.getStore().getPhone());
        storeRepository.save(store);
        return true;
    }

    @Override
    public boolean addAccountShipper(Account_Shipper_Request account) {
        Account account1 = new Account();
        account1.setName(account.getName());
        account1.setPassword(account.getPassword());
        accountRepository.save(account1);
        Shipper shipper = new Shipper();
        shipper.setAccount(account1);
        shipper.setName(account.getShipper().getName());
        shipper.setPhone(account.getShipper().getPhone());
        shipperRepository.save(shipper);
        return true;
    }

    @Override
    public ApiResponse loginAccount(Account_Request account) {
        ApiResponse apiResponse = new ApiResponse();
        Account a = accountRepository.findByName(account.getName());
        if(a != null && a.getPassword().equals(account.getPassword())) {

            if ( userRepository.findByAccount(a) != null) {
                apiResponse.setResult(userRepository.findByAccount(a));
                }
            if ( shipperRepository.findByAccount(a) != null) {
                apiResponse.setResult(shipperRepository.findByAccount(a));
            }
            if ( storeRepository.findByAccount(a) != null) {
                apiResponse.setResult(storeRepository.findByAccount(a));
            }
            return apiResponse;
        }
        return apiResponse;
    }
}
