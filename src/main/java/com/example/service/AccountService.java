package com.example.service;

import java.util.List;
import java.util.Optional;

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
    
    public int registerAccount(Account newAccount){
        if(newAccount.getUsername().isBlank() || newAccount.getPassword().length() < 4){
            //client error
            return 1;
        }
        else if(accountRepo.findByUsername(newAccount.getUsername()) != null){
            //conflict
            return 2;
        }
        else{
            //success
            accountRepo.save(newAccount);
            return 0;
        }
    }

    //login account
    public Account login(String username, String password){
        Optional<Account> getAccount = accountRepo.findByUsernameAndPassword(username, password);
        if(getAccount.isPresent()){
            return getAccount.get();
        }
        return null;
    }
}
