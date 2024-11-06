package com.example.service;

import java.util.List;

// import javax.print.PrintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

@Service
public class AccountService{
    
    @Autowired
    private AccountRepository accountRepo; 
    public AccountService(AccountRepository accountRepo){
        this.accountRepo = accountRepo;
    }
    //get all accounts
    public List<Account> getAccountList(){return (List<Account>) accountRepo.findAll();}

    //registerAccount
    
    public void registerAccount(Account newAccount){
        accountRepo.save(newAccount);
    }
}

// org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'socialMediaController': Unsatisfied dependency expressed through field 'messageService'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.service.MessageService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
