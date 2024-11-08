package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Account;
import com.example.entity.Message;
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
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Registered");
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<Account> login(@RequestBody Account loginAccount){
        Account login = accountService.login(loginAccount.getUsername(), loginAccount.getPassword());
        if(login != null){
            return ResponseEntity.ok(login);
        }
        return ResponseEntity.notFound().build();
    }

    // create new message
    @PostMapping("/messages")
    public @ResponseBody ResponseEntity<Message> createMessage(@RequestBody Message newmMessage){
        return ResponseEntity.ok(messageService.createNewMessage(newmMessage));
    }

    //get all messages
    @GetMapping("/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    //get message by id
    @GetMapping("/messages/{messageId}")
    public @ResponseBody ResponseEntity<Message> getMessageById(@PathVariable int messageId){
        return ResponseEntity.ok(messageService.getMessageById(messageId));
    }

    @DeleteMapping("/messages/{messageId}")
    public @ResponseBody ResponseEntity<?> deleteMessageById(@PathVariable int messageId){
        int rowDeleted = messageService.deleteMessageById(messageId);
        if(rowDeleted == 0){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(rowDeleted);
    }

    @PatchMapping("/messages/{messageId}")
    public @ResponseBody ResponseEntity<String> updateTextById(@PathVariable int messageId){
        return null;
    }
}
