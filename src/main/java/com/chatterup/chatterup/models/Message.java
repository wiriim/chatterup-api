package com.chatterup.chatterup.models;

import java.util.Date;

public class Message {
    private int id;
    private String content;
    private int userId;
    private int chatId;
    private Date date;

    public Message() {
    }

    public Message(int id, String content, int userId, int chatId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.date = new Date();
        this.chatId = chatId;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
