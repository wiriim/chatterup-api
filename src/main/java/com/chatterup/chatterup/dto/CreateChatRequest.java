package com.chatterup.chatterup.dto;

import java.util.List;

public class CreateChatRequest {
    private String name;
    private List<Integer> users;

    public CreateChatRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }
}
