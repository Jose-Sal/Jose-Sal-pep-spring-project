package com.example.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
// import service.AccountService;
import com.example.entity.Account;
// @Repository
public interface AccountRepository {
    // Account accountEntity = new Account();
    //new user registration
        public Account registerAccount(Account account);
        // String sql = "insert into account(username, password) values(?,?)"
        // Connection connect = ConnectionUtil.getConection;
        // return null;
    
}
