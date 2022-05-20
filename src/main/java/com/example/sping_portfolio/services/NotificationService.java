package com.example.sping_portfolio.services;

// interface that has all the methods a notification can do
public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
