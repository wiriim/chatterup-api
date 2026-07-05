package com.chatterup.chatterup.models;

import org.springframework.context.support.MessageSourceAccessor;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private int id;
    private List<Integer> users = new ArrayList<Integer>();
    private List<Message> messages = new ArrayList<Message>();

    public Chat() {
    }

    public Chat(int id, List<Integer> users, Message message) {
        this.id = id;
        this.users = users;
        this.messages.add(message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }
}
