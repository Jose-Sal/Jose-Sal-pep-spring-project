package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.repository.AccountRepository;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepo;
    AccountRepository accountRepo;
    public MessageService(MessageRepository messageRepo, AccountRepository accountRepo){
        this.messageRepo = messageRepo;
        this.accountRepo = accountRepo;
    }

    //create new message
    public Message createNewMessage(Message newMessage){
        if(newMessage.getMessageText().isEmpty() || newMessage.getMessageText().length() > 255 || !accountRepo.existsById(newMessage.getPostedBy())){
            return null;
        }
        else{
            return messageRepo.save(newMessage);
        }
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
    public int updateMessage(int id, Message message){
        Optional<Message> messageFound = messageRepo.findById(id);
        if(messageFound.isPresent()){
            Message messageToUpdate = messageFound.get();
            messageToUpdate.setMessageText(message.getMessageText());
            messageRepo.save(messageToUpdate);
            return 1;
        }
        else{return 0;}
    }

    // find all messages that matches user id
    public List<Message> getAllFromUser(int userId){

        return messageRepo.findBypostedBy(userId).get();
    }
}

