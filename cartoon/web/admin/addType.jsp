<%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/11/23
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object objvalue = session.getAttribute("loginName");
    if(objvalue == null){
        response.sendRedirect("/cartoon_war_exploded/index.jsp");
        return;
    }
%>
<html>
<head>
    <title>添加种类</title>
</head>
<body>
<form action="/cartoon_war_exploded/insert.do" method="post" max="50">
类型名称：<input type="text" name="typeName">
<input type="submit" value="提交">
</form>
</body>
</html>
