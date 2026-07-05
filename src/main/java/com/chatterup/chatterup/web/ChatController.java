package com.chatterup.chatterup.web;

import com.chatterup.chatterup.models.Chat;
import com.chatterup.chatterup.models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ChatController {
    private final Map<Integer, Chat> chats = new HashMap<>();

    @GetMapping("/chats")
    public Collection<Chat> getChats() {
        return chats.values();
    }

    @PostMapping("/chats")
    public Chat createChat(@RequestBody Chat chat){
        chats.put(chat.getId(), chat);
        return chat;
    }

    @PostMapping("/chats/messages")
    public Chat createChat(@RequestBody Message message){
        Chat chat = chats.get(message.getChatId());
        chat.addMessage(message);
        return chat;
    }

}
