package com.chatterup.chatterup.service;

import com.chatterup.chatterup.dto.CreateMessageRequest;
import com.chatterup.chatterup.model.Chat;
import com.chatterup.chatterup.model.Message;
import com.chatterup.chatterup.model.User;
import com.chatterup.chatterup.repository.ChatRepository;
import com.chatterup.chatterup.repository.MessageRepository;
import com.chatterup.chatterup.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public MessageService(MessageRepository messageRepository, ChatRepository chatRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this. userRepository = userRepository;
    }

    public Collection<Message> getChatMessages(int id){
        return messageRepository.findAllByChat_Id(id);
    }

    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public Message createMessage(CreateMessageRequest request){
        Message message = new Message(request.getContent());
        Chat chat = chatRepository.findById(request.getChatId()).orElseThrow();
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        if (!chat.getUsers().contains(user)){
            throw new IllegalArgumentException("User is not part of the chat");
        }

        message.setChat(chat);
        message.setUser(user);

        return messageRepository.save(message);
    }
}
