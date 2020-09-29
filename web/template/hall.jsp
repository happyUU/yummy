
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>呀咪餐厅</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/crc/css/hall.css" />
    <script src="${pageContext.request.contextPath}/static/crc/js/jquery-3.2.1.js"></script>


</head>

<body >
<!-- 网页头部 -->
<div id="main_header">
    <!-- 导航条 -->
    <nav>
        <img src="${pageContext.request.contextPath}/static/crc/images/logo2.png" alt="美食食尚" title="美食食尚" id="logo" />
        <ul id="title">
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
            </li>
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/template/recipe.jsp">菜谱大全</a>
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
        <a href="${pageContext.request.contextPath}/queryhallall.do?">aaaaaa</a>
        <div id="img_Eng">Selection of authenlic ingredients, moving your taste buds.</div>
    </div>
</div>
<!-- 主体部分 -->
<!-- 热门餐厅 -->
<div id="hot_hall">
    <div class="intro">热门餐厅</div>
    <div id="restaurant">
        <ul>
            <li class="rest_name">
                <img src="${pageContext.request.contextPath}/static/crc/${sessionScope.allhalls.get(0).picture}" alt="餐厅">
                <div class="rest_intro">
                    <a href="${pageContext.request.contextPath}/dining.do?method=${sessionScope.allhalls.get(0).hallid}" style="color: #0C0C0C;">
                        <h1>${sessionScope.allhalls.get(0).name}</h1></a>
                    <div class="address">地址：${sessionScope.allhalls.get(0).address}</div>
                    <div class="address">电话：${sessionScope.allhalls.get(0).telphone}</div>
                    <div class="star"><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star">
                    </i></div>
                </div>
            </li>
            <li class="rest_name">
                <img src="${pageContext.request.contextPath}/static/crc/${sessionScope.allhalls.get(1).picture}" alt="餐厅">
                <div class="rest_intro">
                    <a href="${pageContext.request.contextPath}/dining.do?method=${sessionScope.allhalls.get(1).hallid}" style="color: #0C0C0C;">
                        <h1>${sessionScope.allhalls.get(1).name}</h1></a>
                    <div class="address">地址：${sessionScope.allhalls.get(1).address}</div>
                    <div class="address">电话：${sessionScope.allhalls.get(1).telphone}</div>
                    <div class="star"><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>
                </div>
            </li>
            <li class="rest_name">
                <img src="${pageContext.request.contextPath}/static/crc/${sessionScope.allhalls.get(2).picture}" alt="餐厅">
                <div class="rest_intro">
                    <a href="${pageContext.request.contextPath}/dining.do?method=${sessionScope.allhalls.get(2).hallid}" style="color: #0C0C0C;">
                        <h1>${sessionScope.allhalls.get(2).name}</h1></a>
                    <div class="address">地址：${sessionScope.allhalls.get(2).address}</div>
                    <div class="address">电话：${sessionScope.allhalls.get(2).telphone}</div>
                    <div class="star"><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>
                </div>
            </li>
            <li class="rest_name">
                <img src="${pageContext.request.contextPath}/static/crc/${sessionScope.allhalls.get(3).picture}" alt="餐厅">
                <div class="rest_intro">
                    <a href="${pageContext.request.contextPath}/dining.do?method=${sessionScope.allhalls.get(3).hallid}" style="color: #0C0C0C;">
                        <h1>${sessionScope.allhalls.get(3).name}</h1></a>
                    <div class="address">地址：${sessionScope.allhalls.get(3).address}</div>
                    <div class="address">电话：${sessionScope.allhalls.get(3).telphone}</div>
                    <div class="star"><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></div>
                </div>
            </li>
        </ul>
    </div>
</div>
<!-- 热门厨师 -->
<div id="hot_cook">
    <div class="intro">热门厨师</div>
    <ul>
        <li class="cook_mes">
            <img src="${pageContext.request.contextPath}/static/crc/images/b1.jpg" alt="李林">
            <div class="cook_intro">
                <p>崔荣铖</p>
                <p>中国江西</p>
            </div>
        </li>
        <li class="cook_mes">
            <img src="${pageContext.request.contextPath}/static/crc/images/b2.jpg" alt="Teddy">
            <div class="cook_intro">
                <p>路人甲</p>
                <p>中国北京</p>
            </div>
        </li>
        <li class="cook_mes">
            <img src="${pageContext.request.contextPath}/static/crc/images/b3.jpg" alt="李连胜">
            <div class="cook_intro">
                <p>项雷迪</p>
                <p>中国江西</p>
            </div>
        </li>
    </ul>
</div>
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
</body>
<%--<script src="main.js"></script>--%>

</html>
