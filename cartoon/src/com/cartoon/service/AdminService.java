package com.cartoon.service;

import com.cartoon.pojo.Admin;

import java.sql.SQLException;

public interface AdminService {
    //注册
    public boolean register(Admin admin) throws SQLException, ClassNotFoundException;
    public boolean login(Admin admin);
}
