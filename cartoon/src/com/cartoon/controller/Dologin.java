package com.cartoon.controller;

import com.cartoon.pojo.Admin;
import com.cartoon.pojo.User;
import com.cartoon.service.AdminService;
import com.cartoon.service.UserService;
import com.cartoon.service.impl.AdminServiceImpl;
import com.cartoon.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Dologin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        int userType =Integer.parseInt(request.getParameter("userType"));
        boolean isSuccess = false;
        if (userType == 1){
            AdminService service = new AdminServiceImpl();
            Admin admin = new Admin();
            admin.setUserName(userName);
            admin.setUserPwd(userPwd);
            isSuccess = service.login(admin);
            if (isSuccess) {
                //重定向
                //response.sendRedirect("/cartoon_war_exploded/admin/adminIndex.jsp");
                //请求转发
                HttpSession session = request.getSession();
                //session.setAttribute("属性名",属性值);
                session.setAttribute("loginName",userName);
                request.getRequestDispatcher("/admin/adminIndex.jsp").forward(request,response);
            } else {
                response.sendRedirect("/cartoon_war_exploded/index.jsp");
            }
        }
        else if (userType == 0){
            UserService service = new UserServiceImpl();
            User user = new User();
            user.setUserName(userName);
            user.setUserPwd(userPwd);
            isSuccess = service.login(user);
            if (isSuccess) {
                //重定向
                //response.sendRedirect("/cartoon_war_exploded/admin/adminIndex.jsp");
                //请求转发
                HttpSession session = request.getSession();
                //session.setAttribute("属性名",属性值);
                session.setAttribute("loginName",userName);
                request.getRequestDispatcher("/user/userIndex.jsp").forward(request,response);
            } else {
                response.sendRedirect("/cartoon_war_exploded/index.jsp");
            }
        }


    }
}
