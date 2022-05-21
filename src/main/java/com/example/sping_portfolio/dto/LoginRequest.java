package com.example.sping_portfolio.dto;

public class LoginRequest {
    private String username;
    private String password;

    // getter methods
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }

    // setter methods
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
}
