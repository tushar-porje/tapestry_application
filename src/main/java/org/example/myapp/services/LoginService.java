package org.example.myapp.services;

public interface LoginService {
    boolean isValidLogin(String Username, String Password);
    boolean isValidUserName(String userName);
    boolean isValidPassword(String password);
}
