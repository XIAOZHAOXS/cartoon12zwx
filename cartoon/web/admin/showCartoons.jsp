<%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/11/23
  Time: 11:13
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
    <title>更多漫画</title>
</head>
<body>
更多漫画
</body>
</html>
