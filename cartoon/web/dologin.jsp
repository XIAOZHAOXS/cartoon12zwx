<%@ page import="com.cartoon.pojo.Admin" %>
<%@ page import="com.cartoon.service.AdminService" %>
<%@ page import="com.cartoon.service.impl.AdminServiceImpl" %>
<%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/10/11
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userName = request.getParameter("userName");
    String userPwd = request.getParameter("userPwd");
    AdminService service = new AdminServiceImpl();
    Admin admin = new Admin();
    admin.setUserName(userName);
    admin.setUserPwd(userPwd);
    boolean isSuccess = service.login(admin);
    if (isSuccess){
        response.sendRedirect("showList.jsp");
    }
    else {
        response.sendRedirect("login.jsp");
    }
%>
</body>
</html>
