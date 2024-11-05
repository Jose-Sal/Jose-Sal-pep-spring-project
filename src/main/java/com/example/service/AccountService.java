package com.example.service;

import javax.print.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
// import repository.AccountRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
@Service
public class AccountService {
    private AccountRepository accountRepo; 
    @Autowired
    public AccountService(AccountRepository accountRepo){
        this.accountRepo = accountRepo;
    }
    //registerAccount
    
    public Account registerAccount(Account account){
        
        return null;
    }
}
