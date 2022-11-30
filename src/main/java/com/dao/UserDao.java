package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public List<User> getAllUsers();
}
