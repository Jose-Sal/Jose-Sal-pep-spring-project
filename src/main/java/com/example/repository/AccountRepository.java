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
    // public Account registerAccount(Account account);
    
}
// org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'socialMediaController': Unsatisfied dependency expressed through field 'accountService'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'accountService' defined in file [/workspace/Jose-Sal-pep-spring-project/target/classes/com/example/service/AccountService.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'accountRepository' defined in com.example.repository.AccountRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Invocation of init method failed; nested exception is org.springframework.data.repository.query.QueryCreationException: Could not create query for public abstract com.example.entity.Account com.example.repository.AccountRepository.registerAccount(com.example.entity.Account)! Reason: Failed to create query for method public abstract com.example.entity.Account com.example.repository.AccountRepository.registerAccount(com.example.entity.Account)! No property registerAccount found for type Account!; nested exception is java.lang.IllegalArgumentException: Failed to create query for method public abstract com.example.entity.Account com.example.repository.AccountRepository.registerAccount(com.example.entity.Account)! No property registerAccount found for type Account!
