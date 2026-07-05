package com.chatterup.chatterup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private final Map<Integer, String> users = new HashMap<>() {{
        put(1, "John");
        put(2, "Doe");
        put(3, "Smith");
        put(4, "Jane");
    }};

    @GetMapping("/users")
    public Collection<String> getUsers() {
        return users.values();
    }
}
