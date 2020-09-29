<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/14
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>呀咪购物</title>
    <%@ include file="/template/head.jsp"%>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/public.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/shopping.css" />
    <script src="${pageContext.request.contextPath}/static/hqx/js/shopping.js" ></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/public.js"></script>

</head>

<body>
<!-- 网页头部 -->
<div id="main_header">
    <!-- 导航条 -->
    <nav>
        <img src="${pageContext.request.contextPath}/static/xsr/images/logo2.png" alt="美食食尚" title="美食食尚" id="logo" />
        <ul id="title">
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
            </li>
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/template/dining.jsp">菜谱大全</a>
            </li>
            <%--<li class="pageName">
                <a href="${pageContext.request.contextPath}/template/dining.jsp">每日推荐</a>
            </li>--%>
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/template/hall.jsp">呀咪餐厅</a>
            </li>
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/template/shopping.jsp">呀咪购物</a>
            </li>
        </ul>
        <c:if test="${empty user}" >
            <a href="${pageContext.request.contextPath}/login.jsp" id="login" >用户登录</a>
        </c:if>
        <c:if test="${!empty user}">
            <a href="${pageContext.request.contextPath}/template/user.jsp" id="login" >个人中心</a>
        </c:if>
    </nav>
    <div id="back_img">
        <div id="img_food">甄选地道食材， 刺激您的味蕾</div>
        <div id="img_Eng">Selection of authenlic ingredients, moving your taste buds.</div>
    </div>
</div>
<!-- 网页主体 -->
<ul id="shop_type">
    <li class="diff_choose">
        <div class="second_title">呀咪厨具</div>
        <ul id="cooker_goods">

        </ul>
    <li class="diff_choose">
        <div class="second_title">呀咪生鲜</div>
        <ul id="fruits_goods">

        </ul>
    </li>
    <li class="diff_choose">
        <div class="second_title">呀咪零食</div>
        <ul id="snacks_goods">

        </ul>
    </li>
</ul>
<%--<div id="shoppingCar">我的购物车<i class="fas fa-shopping-cart"></i></div>--%>
<footer>
    <div id="ymmy">Yummy</div>
    <ul>
        <li class="some_mess">Home</li>
        <li class="some_mess">About</li>
        <li class="some_mess">p&g</li>
        <li class="some_mess">News</li>
        <li class="some_mess">@2018 yummy com Allright resrverd</li>
    </ul>
</footer>

<%@ include file="/template/gotop.jsp"%>
</body>
</html>

