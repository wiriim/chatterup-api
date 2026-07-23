package com.chatterup.chatterup.web;

import com.chatterup.chatterup.dto.ChatResponse;
import com.chatterup.chatterup.dto.CreateChatRequest;
import com.chatterup.chatterup.dto.CreateMessageRequest;
import com.chatterup.chatterup.model.Chat;
import com.chatterup.chatterup.model.Message;
import com.chatterup.chatterup.model.User;
import com.chatterup.chatterup.service.ChatService;
import com.chatterup.chatterup.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@CrossOrigin
public class ChatController {
    private final ChatService chatService;
    private final MessageService messageService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(ChatService chatService, MessageService messageService, SimpMessagingTemplate simpMessagingTemplate) {
        this.chatService = chatService;
        this.messageService = messageService;
        this. simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/chat/{userId}")
    @Transactional(propagation= Propagation.REQUIRED, noRollbackFor=Exception.class)
    public void sendMessage(CreateMessageRequest request){
        Message message = messageService.createMessage(request);
        Chat chat = chatService.getChatById(message.getChat().getId()).orElseThrow();
        ChatResponse chatResponse = new ChatResponse(chat.getId(), chat.getName(), chat.getMessages().get(chat.getMessages().size()-1));
        for (User user : chat.getUsers()){
            simpMessagingTemplate.convertAndSend("/chat/" + user.getId(), chatResponse);
        }
    }

    @GetMapping("/chats")
    public Collection<Chat> getChats() {
        return chatService.getAll();
    }

    @GetMapping("/chats/{id}")
    public Optional<Chat> getChatById(@PathVariable int id) {
        return chatService.getChatById(id);
    }

    @PostMapping("/chats")
    public Chat createChat(@RequestBody CreateChatRequest request) {
        return chatService.createChat(request);
    }

    @GetMapping("/chats/{id}/messages")
    public Collection<Message> getChatMessages(@PathVariable int id) {
        return messageService.getChatMessages(id);
    }

    @PostMapping("/chats/messages")
    public Message createMessage(@RequestBody CreateMessageRequest request) {
        return messageService.createMessage(request);
    }

}
