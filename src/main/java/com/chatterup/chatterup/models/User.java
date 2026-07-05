package com.chatterup.chatterup.models;

public class User {
    private Integer id;
    private String username;
    private String picture;

    public User() {
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(Integer id, String username, String picture) {
        this.id = id;
        this.username = username;
        this.picture = picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
