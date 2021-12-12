<%--
  Created by IntelliJ IDEA.
  User: 赵文瑄
  Date: 2021/10/14
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员注册</title>
    <script type="text/javascript" language="JavaScript">
    function validate() {
        var userName = document.getElementById("userName").value;
        if(userName.length<=0){
            alert("用户名不能为空！");
            document.getElementById("userName").focus();
            return false;
        }
        var userPwd = document.getElementById("userPwd").value;
        if (userPwd<=0){
            alert("密码不能为空！");
            document.getElementById("userPwd").focus();
            return false;
        }
        var querenuserPwd = document.getElementById("querenuserPwd").value;
        if (querenuserPwd.length<=0){
            alert("确认密码不能为空！");
            document.getElementById("querenuserPwd").focus();
            return false;
        }
        if (querenuserPwd!=userPwd){
            alert("两次输入密码不同！请重新输入！");
            document.getElementById("querenuserPwd").focus();
            document.getElementById("querenuserPwd").value="";
            return false;
        }
        return true;
    }
    </script>
</head>
<body>
<h2>管理员注册</h2>
    <form action="/cartoon_war_exploded/register.do" onsubmit="return validate()">
用户名：<input type="text" name="userName" id="userName"><br/>
密码：<input type="password" name="userPwd" id="userPwd"><br/>
确认密码：<input type="password" name="querenuserPwd" id="querenuserPwd"><br/>
真实姓名：<input type="text" name="trueName" id="trueName"><br/>
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
</body>
</html>
