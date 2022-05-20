package com.example.sping_portfolio.services;

import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class UserServiceStubImpl implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
        return Objects.equals(username, password);
    }
}
