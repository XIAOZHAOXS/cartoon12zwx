package com.cartoon.controller;


import com.cartoon.pojo.Admin;
import com.cartoon.service.AdminService;
import com.cartoon.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DoRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String trueName = request.getParameter("trueName");
        AdminService service = new AdminServiceImpl();
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setUserPwd(userPwd);
        admin.setTrueName(trueName);
        boolean isSuccess = false;
        try {
            isSuccess = service.register(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (isSuccess) {
            response.sendRedirect("/cartoon_war_exploded/login.jsp");
        } else {
            response.sendRedirect("/cartoon_war_exploded/zhuce.jsp");
        }
    }
}
