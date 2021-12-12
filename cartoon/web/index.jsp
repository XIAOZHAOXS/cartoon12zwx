<%@ page language="java" pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>漫画中国</title>
<link href="CSS/main.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="header">
<div id="top_login">   
<form name="loginform" action="/cartoon_war_exploded/login.do" method="post">
	 <label> 登录名 </label>
     <input type="text" id="userName" name="userName" value="" class="login_input" />
     <label> 密&#160;&#160;码 </label>
     <input type="password" id="userPwd" name="userPwd" value="" class="login_input"/>
	 <select name="userType">
	   <option value="0">会员</option>
	   <option value="1">管理员</option>
	 </select>
     <input type="submit" class="login_sub" value="登录" />
    &nbsp;&nbsp;
    <input type="button" class="login_sub" value="注册" />
</form>
</div>
  <div id="nav">
    <div id="logo"> <img src="Images/logo.jpg" alt="漫画中国" /> </div>
    <div id="a_b01"> <img  src="Images/a_b01.gif" alt="" width="780" height="66" vspace="2" /> </div>
    <!--漫画logo--><!--这是HTML注释 -->
  </div>
</div>
<div id="container">
  <div class="sidebar">
    <h1> <img src="Images/title_1.gif" alt="国内漫画" /> </h1>
    <div class="side_list">
      <ul style="margin-left:8px; margin-top:6px">
	     <li> <a href='https://www.mkzhan.com/43/'><b> 偷星九月天 </b></a> </li>
         <li> <a href='https://www.mkzhan.com/207874/'><b> 封神斗战榜 </b></a> </li>
         <li> <a href='https://www.mkzhan.com/49733/'><b> 斗破苍穹</b></a> </li>
         <li> <a href='https://www.mkzhan.com/208527/'><b> 火锅家族</b></a> </li>
		 <li> <a href='https://www.mkzhan.com/210993/'><b> 见习魔法师 </b></a> </li>
		 <li> <a href='http://www.1kkk.com/manhua37596/'><b> 菠萝范脑洞小漫画 </b></a> </li>
      </ul>
    </div>
	
  </div>
 <div class="main">
    <div class="class_type"> <img src="Images/class_type.gif" alt="漫画中心" /> </div>
    <div class="content">
      <ul class="class_date">
        <li id='class_month'> 
		<a href='#'><b> 科幻类 </b></a> 
		<a href='#'><b> 竞技类 </b></a> 
		<a href='#'><b> 格斗类 </b></a>
		<a href='#'><b> 冒险类 </b></a> 
		<a href='#'><b> 爱情类 </b></a> 
		<a href='#'><b> 侦探类 </b></a> 
		<a href='#'><b> 幽默类 </b></a> 
		<a href='#'><b> 神话类 </b></a> 
	</li>

      </ul>
      <ul class="classlist">
        <li><a href='http://www.1kkk.com/manhua21077/'> Bloody Girl</a><span> 2017-10-28 发布 </span></li>
        <li><a href='http://www.1kkk.com/manhua35763/'> 机器人的高尔夫激光炮</a><span> 2017-10-28 发布 </span></li>
        <li><a href='http://www.1kkk.com/manhua38659/'> 鹰和鸢和油豆腐</a><span> 2017-10-28 发布 </span></li>
        <li><a href='http://www.1kkk.com/manhua10863/'> 会长君的下仆</a><span> 2017-10-28 发布 </span></li>
        <li><a href='http://www.1kkk.com/manhua22851/'> 假面骑士空我</a><span> 2017-10-28 发布 </span></li>
        <li><a href='http://www.1kkk.com/manhua20757/'> 解谎侦探少女 </a><span> 2017-10-28 发布</span></li>
        <li><a href='http://www.1kkk.com/manhua37517/'> 星期一的朋友 </a><span> 2017-10-28 发布</span></li>
        <li><a href='http://www.1kkk.com/manhua23874/'> 儿子可爱过头的魔族母亲 </a><span> 2017-10-28 发布</span></li>       

      </ul>
    </div> 
    </div>
    
  </div>
</div>

</body>
</html>
