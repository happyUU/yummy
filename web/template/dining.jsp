<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>呀咪餐厅</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/css/hall.css" />--%>
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/crc/css/recipe.css" />
</head>

<body>
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
            <li class="pageName">
                <a href="${pageContext.request.contextPath}/template/dining.jsp">每日推荐</a>
            </li>
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
<!-- 主体部分 -->
<div style="width:100%; background-color: #0C0C0C">
    <h1 style="text-align: center;padding-top: 100px">${sessionScope.hall.name} <a href="#">立即预约</a></h1>
    <div id="food_show">
        <ul id="example">
            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food1.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/1.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food1.dishid}">${sessionScope.food1.disname}</a></h1>
                <h1>￥${sessionScope.food1.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food2.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/2.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food2.dishid}">${sessionScope.food2.disname}</a></h1>
                <h1>￥${sessionScope.food2.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food3.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/3.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food3.dishid}">${sessionScope.food3.disname}</a></h1>
                <h1>￥${sessionScope.food3.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food1.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/1.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food1.dishid}">${sessionScope.food1.disname}</a></h1>
                <h1>￥${sessionScope.food1.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food2.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/2.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food2.dishid}">${sessionScope.food2.disname}</a></h1>
                <h1>￥${sessionScope.food2.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food3.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/3.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food3.dishid}">${sessionScope.food3.disname}</a></h1>
                <h1>￥${sessionScope.food3.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food1.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/1.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food1.dishid}">${sessionScope.food1.disname}</a></h1>
                <h1>￥${sessionScope.food1.disprice}.00</h1>
                <p></p>
            </li>
            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food2.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/2.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food2.dishid}">${sessionScope.food2.disname}</a></h1>
                <h1>￥${sessionScope.food2.disprice}.00</h1>
                <p></p>
            </li>

            <li class="exam_message">
                <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food3.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/3.jpg';this.onerror=null"/>
                <h1><a href="${pageContext.request.contextPath}/foodsp.do?method=${sessionScope.food3.dishid}">${sessionScope.food3.disname}</a></h1>
                <h1>￥${sessionScope.food3.disprice}.00</h1>
                <p></p>
            </li>
        </ul>
    </div>



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
<%--<script src="${pageContext.request.contextPath}/static/crc/js/main.js"></script>--%>

</html>
