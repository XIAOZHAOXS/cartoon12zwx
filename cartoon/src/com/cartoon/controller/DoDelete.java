package com.cartoon.controller;

import com.cartoon.service.CartoonTypeService;
import com.cartoon.service.impl.CartoonTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String typeName = request.getParameter("name");
        System.out.println(typeName);
        CartoonTypeService service = new CartoonTypeServiceImpl();
        boolean isSuccess = service.delete(typeName);
        if (isSuccess){
            request.getRequestDispatcher("/types.get").forward(request,response);
        }else {
            request.getRequestDispatcher("/admin/fail.jsp").forward(request,response);
        }
    }
}
