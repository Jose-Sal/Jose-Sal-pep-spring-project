package com.example.service;

import org.springframework.stereotype.Service;
// import repository.AccountRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.repository.AccountRepository;
@Service
public class AccountService {
    AccountRepository accountRepo; 
    //registerAccount
    @RequestMapping("entity/Account")
    public Account registerAccount(){
        return null;
    }
}
