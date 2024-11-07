package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepo;
    public MessageService(MessageRepository messageRepo){
        this.messageRepo = messageRepo;
    }
    //create new message
    public Message createNewMessage(Message newmMessage){
        return messageRepo.save(newmMessage);
    }
}
