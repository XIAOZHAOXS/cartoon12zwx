<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    Object objvalue = session.getAttribute("loginName");
    if(objvalue == null){
        response.sendRedirect("/cartoon_war_exploded/index.jsp");
        return;
    }
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'user.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="CSS/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用我的漫画网站！</div>
    <div id="nav">
        <div id="logo"><img src="Images/logo.jpg" alt="漫画中国" /></div>
        <div id="a_b01"><img src="Images/a_b01.gif" alt="" width="787" height="72" vspace="2" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">会员：<%=(String)objvalue%>             &#160;&#160;&#160;&#160; <a href="#">注销</a></div>
    <div id="channel"> </div>
</div>
<div name="cartoondiv" id="main">
    <div id="opt_list">
        <ul>
            <li><a href="/cartoon_war_exploded/admin/showTypes.jsp" target="context">更多种类</a></li>
            <li><a href="/cartoon_war_exploded/admin/showCartoons.jsp" target="context">更多漫画</a></li>
        </ul>
    </div>
    <div id="opt_area">
        <iframe name="context" width="765px" onload="this.height=this.contentWindow.document.body.scrollHeight" scrolling="no" frameborder="0"></iframe>
    </div>
</div>

</body>
</html>
