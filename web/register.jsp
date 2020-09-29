<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/15
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>yummy-注册</title>
</head>
<body>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/xsr/css/register.css" />
    <script src="${pageContext.request.contextPath}/static/xsr/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/xsr/js/register.js"></script>
</head>

<body>
<div id="register_back">
    <div id="box_back">
        <form action="${pageContext.request.contextPath}/register.action" method="post">
            <div class="regis_box">用户名：
                <input type="text" placeholder="请输入您的昵称" class="normal_input" id="username" name="username">
            </div>
            <div class="regis_box">手机号：
                <input type="text" placeholder="请输入您的常用手机号" class="normal_input" id="cellphone" name="phone">
            </div>
            <div class="regis_box">邮&nbsp;&nbsp;&nbsp;箱：
                <input type="email" placeholder="请输入您的常用邮箱" class="normal_input" id="email" name="email">
            </div>
            <!--<div class="regis_box">地   址：
                <input type="email" placeholder="请输入您的地址" class="normal_input" id="address">
            </div>-->
            <div class="regis_box">密&nbsp;&nbsp;&nbsp;码：
                <input type="password" placeholder="请输入6-16个字符" class="normal_input" id="password" name="password">
            </div>
            <div class="regis_box">确认密码：
                <input type="password" placeholder="请再次输入您的密码" class="normal_input" id="sure_pass" name="cPassword">
            </div>
            <div class="regis_box">支付密码：
                <input type="password" placeholder="请输入6-16个字符" class="normal_input" id="pPassword" name="pPassword">
            </div>
            <div class="regis_box">确认密码：
                <input type="password" placeholder="请再次输入您的密码" class="normal_input" id="pSure_pass" name="cpPassword">
            </div>
            <div class="regis_box">验证码：
                <input type="text" placeholder="请输入验证码" id="regis_code" name="checkCode">

            </div>
            <div class="regis_box" id="btn_box">
                <input id="regis_btn" type="submit" value="注 册"></input>
            </div>
            <a href="${pageContext.request.contextPath}/login.jsp" id="login" >已有账号？快去登录吧</a><br/>
            <a href="${pageContext.request.contextPath}/index.jsp" class="return">算了我先逛逛</a>
        </form>

    </div>
</div>
</body>

</html>
</body>
</html>
