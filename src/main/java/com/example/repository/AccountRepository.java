package com.example.repository;

import java.util.Optional;

// import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import org.springframework.web.bind.annotation.GetMapping;
// import service.AccountService;
import com.example.entity.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    Optional<Account> findByUsernameAndPassword(String username, String password);
    Optional<Account> findByUsername(String username);
}