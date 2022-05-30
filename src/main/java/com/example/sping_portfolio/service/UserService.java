package com.example.sping_portfolio.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.sping_portfolio.login.UserRegistrationDto;
import com.example.sping_portfolio.login.User;

// interface for methods that get user data
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    List<User> getAll();
}