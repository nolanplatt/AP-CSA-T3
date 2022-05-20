package com.example.sping_portfolio.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
    // sets constraint on username size
    @Size(min=2, max=30, message="Your username should be 2-30 characters")
    private String username;

    // sets constraint on password existing and its size
    @NotNull
    @Size(min=1, max=50)
    private String password;

    // getter methods
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    // setter methods
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}