package com.cartoon.controller;

import com.cartoon.pojo.CartoonType;
import com.cartoon.service.CartoonTypeService;
import com.cartoon.service.impl.CartoonTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetTypes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        CartoonTypeService service = new CartoonTypeServiceImpl();
        //1、接收传递的参数
        int pageNo = 1;
        String strPageNo = request.getParameter("pageNo");
        if (strPageNo != null){
            pageNo = Integer.parseInt(strPageNo);
        }
        int pageSize = 3;
        int pageCount = service.getpageCount(pageSize);
        //2、调用业务逻辑
        List<CartoonType> list = service.getCartoonTypes(pageNo,pageSize);
        HttpSession session = request.getSession();
        //3、页面跳转
        session.setAttribute("CartoonTypes",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/admin/showTypes.jsp").forward(request, response);
    }
}
