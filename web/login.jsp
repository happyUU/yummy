<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/16
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/xsr/css/login.css" />
</head>

<body>
<div id="back">
    <form action="${pageContext.request.contextPath}/login.action" method="post">
        <div id="login_box">
            <div class="login_input">用户名：
                <input type="text" placeholder="请输入手机号" id="username" name="phone">
            </div>
            <div class="login_input">密&nbsp;&nbsp;&nbsp;码：
                <input type="password" placeholder="请输入密码" id="password" name="password">
            </div>
            <div id="rem_btn">
                <input type="checkbox" id="remember" name="rem" value="check">
                <span>记住密码</span>
            </div>
            <!--<a href="" id="forget">忘记密码？</a>-->
            <div class="login_input">
                <input id="login_btn" type="submit" value="提 交" />
                <!--<button id="login_btn">登 录</button>-->
            </div>
            <a href="${pageContext.request.contextPath}/register.jsp" id="register">还没有账号？快去注册吧</a><br/>
            <div align="center">
                <a href="${pageContext.request.contextPath}/index.jsp" class="return">算了先逛逛</a>
                <a href="${pageContext.request.contextPath}/adminlogin.jsp" class="login">管理登录</a>
            </div>
        </div>
    </form>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/xsr/js/jquery-3.2.1.js"></script>
<%--<script src="../static/js/login.js"></script>--%>
</html>
