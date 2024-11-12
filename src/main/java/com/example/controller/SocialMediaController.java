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

    //register user account using PostMapping
    @PostMapping("/register")
    public @ResponseBody ResponseEntity<?> registerUser(@RequestBody Account newAccount){
        int status = accountService.registerAccount(newAccount);
        switch (status) {
            case 1:
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            case 2:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username Already Exist");
                
            default:
                return ResponseEntity.ok(newAccount);
        }
        
    }

    @PostMapping("/login")
    public @ResponseBody ResponseEntity<Account> login(@RequestBody Account loginAccount){
        Account login = accountService.login(loginAccount.getUsername(), loginAccount.getPassword());
        if(login != null){
            return ResponseEntity.ok(login);
        }
        else{return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);}
        
    }

    // create new message
    @PostMapping("/messages")
    public @ResponseBody ResponseEntity<Message> createMessage(@RequestBody Message newmMessage){
        Message createdMessage = messageService.createNewMessage(newmMessage);
        if(createdMessage != null){
            return ResponseEntity.ok(createdMessage);
        }
        else{ return new ResponseEntity<>(createdMessage, HttpStatus.BAD_REQUEST);}
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
    //update message text
    @PatchMapping("/messages/{messageId}")
    public @ResponseBody ResponseEntity<?> updateTextById(@PathVariable int messageId, @RequestBody Message updatedMessage){
        int rowDeleted = messageService.updateMessage(messageId, updatedMessage);
        if(rowDeleted == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(rowDeleted);    
    }

    //find all message by a user
    @GetMapping("accounts/{accountId}/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAllByAccounts(@PathVariable int accountId){
        return ResponseEntity.ok( messageService.getAllFromUser(accountId));
    }
}
