package com.cartoon.service.impl;

import com.cartoon.dao.AdminDao;
import com.cartoon.dao.impl.AdminDaoImpl;
import com.cartoon.pojo.Admin;
import com.cartoon.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean register(Admin admin) throws SQLException, ClassNotFoundException {
        //1.声明一个变量，并赋值初始值
        boolean isSuccess = false;
        //2.具体操作
        AdminDao dao = new AdminDaoImpl();
        Admin queryAdmin = dao.select(admin.getUserName());
        if(queryAdmin == null){
           int row = dao.insert(admin);
           if(row > 0){
               isSuccess = true;
           }
        }
        //3.返回第一步声明的变量
        return isSuccess;
    }

    @Override
    public boolean login(Admin admin) {
        boolean isSuccess = false;
        AdminDao dao = new AdminDaoImpl();
        Admin queryAdmin = dao.select(admin.getUserName());
        if (queryAdmin != null && admin.getUserPwd().equals(queryAdmin.getUserPwd())){
                isSuccess = true;
        }
        return isSuccess;
    }
}
