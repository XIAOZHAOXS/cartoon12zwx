package com.cartoon.dao;

import com.cartoon.pojo.Admin;

import java.util.List;

public interface AdminDao {
    public int insert(Admin admin);
    public int update(Admin admin);
    public int delete(Admin admin);
    public Admin select(String username);
    public List<Admin> select();
}
