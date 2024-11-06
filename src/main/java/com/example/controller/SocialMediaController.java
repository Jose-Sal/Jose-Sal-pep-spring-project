package com.example.controller;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Account;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@Controller
public class SocialMediaController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private MessageService messageService;

    SocialMediaController(){}
    SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }
    // @Autowired
    // SocialMediaController(MessageService messageService){
    //     this.messageService = messageService;
    // }
    //creating post endpoint for user registration
    // @RequestMapping("entity/Account")
    @PostMapping("/register")
    public @ResponseBody ResponseEntity<String> registerUser(@RequestBody Account newAccount){
        accountService.registerAccount(newAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Registered");
    }
}
