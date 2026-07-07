package com.chatterup.chatterup.service;

import com.chatterup.chatterup.dto.CreateChatRequest;
import com.chatterup.chatterup.model.Chat;
import com.chatterup.chatterup.model.User;
import com.chatterup.chatterup.repository.ChatRepository;
import com.chatterup.chatterup.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public Collection<Chat> getAll(){
        return chatRepository.findAll();
    }

    public Optional<Chat> getChatById(int id){
        return chatRepository.findById(id);
    }

    public Chat createChat(CreateChatRequest request){
        if (request.getUsers() == null || request.getUsers().size() < 2) {
            throw new IllegalArgumentException("Chat requires at least 2 users");
        }

        Chat chat = new Chat(request.getName());
        List<User> users = userRepository.findAllById(request.getUsers());

        if (users.size() != request.getUsers().size()) {
            throw new IllegalArgumentException("One or more users do not exist");
        }

        chat.setUsers(users);

        return chatRepository.save(chat);
    }
}
