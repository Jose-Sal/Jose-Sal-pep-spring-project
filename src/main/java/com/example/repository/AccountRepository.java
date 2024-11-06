package com.example.repository;

// import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.web.bind.annotation.GetMapping;
// import service.AccountService;
import com.example.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    //new user registration
    public Account registerAccount(Account account);
    
}
