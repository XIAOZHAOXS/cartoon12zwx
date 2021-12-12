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
    <title>添加漫画</title>
</head>
<body>
<form>
    <ul>
        <li><input type="text" name="cid"></li>
        <li><input type="text" name="typeId"></li>
        <li><input type="text" name="cTitle"></li>
        <li><input type="text" name="cAuthor"></li>
        <li><input type="text" name="content"></li>
        <li><input type="text" name="pic"></li>
        <li><input type="text" name="url"></li>
        <li><input type="date" name="issueDate"></li>
        <li><input type="text" name="upDateSlot"></li>
        <li><input type="text" name="issuer"></li>
        <li><input type="text" name="publish"></li>
        <li><input type="text" name="stock"></li>
        <input type="submit" value="提交">
    </ul>
</form>
</body>
</html>
