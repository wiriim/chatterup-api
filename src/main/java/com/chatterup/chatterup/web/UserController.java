package com.chatterup.chatterup.web;

import com.chatterup.chatterup.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final Map<Integer, User> users = new HashMap<>() {{
        put(1, new User(1, "John"));
        put(2, new User(2, "Doe"));
        put(3, new User(3, "Smith"));
        put(4, new User(4, "Jane"));
    }};

    @GetMapping("/users")
    public Collection<User> getUsers() {
        return users.values();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return users.get(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        users.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
