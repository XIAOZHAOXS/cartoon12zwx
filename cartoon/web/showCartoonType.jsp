<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/9/30
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/cartoondb";
    String user = "root";
    String password = "123456";
        Connection con = DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt = con.prepareStatement("select * from cartoontype");
        ResultSet rs = pstmt.executeQuery();
        if (rs!=null){
        while (rs.next()){
%>
  <%=rs.getString("typename")%>
<%
        }
        }else {
            %>
     没有任何漫画类型
    <%
        }
    if (rs!=null){
        rs.close();
    }
    if (pstmt!=null){
        pstmt.close();
    }
    if (con!=null && !con.isClosed()){
        con.close();
    }
    %>
</body>
</html>
