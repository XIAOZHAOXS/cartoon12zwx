package com.cartoon.dao;

import com.cartoon.pojo.User;

public interface UserDao {
    public User select(String username);
}
