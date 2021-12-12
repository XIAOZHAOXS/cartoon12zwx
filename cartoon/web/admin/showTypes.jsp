<%@ page import="com.cartoon.dao.CartoonTypeDao" %>
<%@ page import="com.cartoon.dao.impl.CartoonTypeDaoImpl" %>
<%@ page import="com.cartoon.pojo.CartoonType" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cartoon.service.CartoonTypeService" %>
<%@ page import="com.cartoon.service.impl.CartoonTypeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/11/23
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object objvalue = session.getAttribute("loginName");
    if (objvalue == null) {
        response.sendRedirect("/cartoon_war_exploded/index.jsp");
        return;
    }
%>
<html>
<head>
    <title>更多种类</title>
    <link href="CSS/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%--<%--%>
<%--    CartoonTypeDao dao = new CartoonTypeDaoImpl();--%>
<%--    List<CartoonType> list = dao.select();--%>
<%--    for (int i = 0;i < list.size();i++){--%>
<%--%>--%>
<%--<ul>--%>
<%--    <li><%=list.get(i).getTypeName()%></li>--%>
<%--</ul>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>
<table border="0" width="600px">
    <tr bgcolor="#f4fbff">
        <td colspan="3">类型名称</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <%
        Object objList = session.getAttribute("CartoonTypes");
        List<CartoonType> list = (List<CartoonType>) objList;
        Object objPageNo = request.getAttribute("pageNo");
        int pageNo = 1;
        if (objPageNo != null){
            pageNo = ((Integer)objPageNo).intValue();
        }
        Object objPageCount = request.getAttribute("pageCount");
        int pageCount=1;
        if (objPageCount != null){
            pageCount = ((Integer)objPageCount).intValue();
        }
        HttpSession session1 = request.getSession();
        if (list == null || list.size() == 0) {
    %>
    <tr>
        <td colspan="3"></td>
    </tr>
    <%
        }
        for (int i = 0; i < list.size(); i++) {
            session1.setAttribute("Delete", list.get(i).getTypeName());
            if ((i + 1) % 2 == 0) {
    %>
    <tr class="r_two">
            <%
            }else {
                %>
    <tr class="r_one">
        <%
            }
        %>
        <td id="typeName"><%=list.get(i).getTypeName()%>
        </td>
        <td><a href="">修改</a></td>
        <td><a href="/cartoon_war_exploded/delete.do?name=<%=list.get(i).getTypeName()%>">删除</a></td>
    </tr>
    <%
        }
    %>
</table>
<%
    if (pageNo > 1){
%>
<a href="/cartoon_war_exploded/types.get?pageNo=<%=pageNo-1%>">上一页</a>
<%
    }
%>
<%
    if (pageNo < pageCount){
%>
<a href="/cartoon_war_exploded/types.get?pageNo=<%=pageNo+1%>">下一页</a>
<%
    }
%>
</body>
</html>
