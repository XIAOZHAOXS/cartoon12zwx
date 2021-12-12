package com.cartoon.service.impl;

import com.cartoon.dao.UserDao;
import com.cartoon.dao.impl.UserDaoImpl;
import com.cartoon.pojo.User;
import com.cartoon.service.UserService;

public class UserServiceImpl implements UserService {
    public boolean login(User user) {
        boolean isSuccess = false;
        UserDao dao = new UserDaoImpl();
        User queryUser = dao.select(user.getUserName());
        if (queryUser != null && user.getUserPwd().equals(queryUser.getUserPwd())){
            isSuccess = true;
        }
        return isSuccess;
    }
}
