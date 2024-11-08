package com.example.service;

import java.util.List;
import java.util.Optional;

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
    //get all messages
    public List<Message> getAllMessages(){
        return (List<Message>) messageRepo.findAll();
    }
    //get message by id
    public Message getMessageById(int id){
        Optional<Message> retrievedMessage = messageRepo.findById(id);
        if(retrievedMessage.isPresent()){
            return retrievedMessage.get();
        }
        return null;
    }

    //Delete message by Id 
    public int deleteMessageById(int id){
        Optional<Message> deletedMessage = messageRepo.findById(id);
        if(deletedMessage.isPresent()){
            messageRepo.deleteById(id);
            return 1;
        }
        else{return 0;}
    }

    //update messageText by id
    public String updateString(String messageText){
        return null;
    }
}

