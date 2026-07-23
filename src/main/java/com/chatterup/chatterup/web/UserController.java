package com.chatterup.chatterup.web;

import com.chatterup.chatterup.model.Chat;
import com.chatterup.chatterup.model.User;
import com.chatterup.chatterup.service.ChatService;
import com.chatterup.chatterup.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final ChatService chatService;

    public UserController(UserService userService, ChatService chatService) {
        this.userService = userService;
        this.chatService = chatService;
    }

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/users/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/users/{username}/chats")
    public Collection<Chat> getUserChats(@PathVariable String username) {
        return chatService.getUserChats(username);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        Optional<User> currentUser = userService.getByUsername(user.getUsername());

        if (currentUser.isEmpty()){
            return userService.createUser(user);
        }

        return currentUser.orElseThrow();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
