package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
// import repository.AccountRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
@Service
public class AccountService {
    AccountRepository accountRepo; 
    //registerAccount
    
    public Account registerAccount(Account account){
        
        return null;
    }
}
