package com.chatterup.chatterup.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "user_chat",
            joinColumns = @JoinColumn(name = "chatId"),
            inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> users;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    @OrderBy("date asc")
    private List<Message> messages;

    public Chat() {
    }

    public Chat(String name) {
        this.name = name != null ? name : "New Chat";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
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
