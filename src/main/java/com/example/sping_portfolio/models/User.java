package com.example.sping_portfolio.models;

import java.util.HashSet;
import java.util.Set;

public class User {
    // instance variables
    private Long id;
    private String username;
    private String passwordHash;
    private String fullName;
    private Set<Post> posts = new HashSet<>();

    // setter methods
    public void setId(Long id) {this.id = id;}
    public void setUsername(String username) {this.username = username;}
    public void setPasswordHash(String passHash) {this.passwordHash = passHash;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public void setPosts(Set<Post> posts) {this.posts = posts;}

    // getter methods
    public Long getId() {return id;}
    public String getUsername() {return username;}
    public String getPasswordHash() {return passwordHash;}
    public String getFullName() {return fullName;}
    public Set<Post> getPosts() {return posts;}

    // constructors
    public User() {}
    public User(Long id, String username, String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }

    // default toString
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", passwordHash='" + passwordHash + '\'' + ", fullName='" + fullName + '\'' + '}';
    }
}
