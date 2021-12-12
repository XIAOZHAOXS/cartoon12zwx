<%@ page import="com.cartoon.service.AdminService" %>
<%@ page import="com.cartoon.service.impl.AdminServiceImpl" %>
<%@ page import="com.cartoon.pojo.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/10/14
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册操作实现页面</title>
</head>
<body>
    <%
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        String trueName = request.getParameter("trueName");
        AdminService service = new AdminServiceImpl();
        Admin admin = new Admin();
        admin.setUserName(userName);
        admin.setUserPwd(userPwd);
        admin.setTrueName(trueName);
        boolean isSuccess = service.register(admin);
        if (isSuccess){
            response.sendRedirect("login.jsp");
        }else {
            response.sendRedirect("zhuce.jsp");
        }
    %>
</body>
</html>
