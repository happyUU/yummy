<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>美食商城</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/crc/css/style.css">
</head>
<body>
<nav class="nav1">
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

<div style="background-image:url(../static/crc/images/an.png);margin-top: -40px">
    <div style="height: 400px">

        <div width="330" style="margin-top:50px;margin-left: 50px;float: left">
            <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food.dispic}" style="width:320px ;height:240px" >
        </div>

        <div style="margin-top:40px;margin-left:400px;">
            <table cellspacing="15" >
                <tr>
                    <td colspan="2"><h1 >${sessionScope.food.disname}</h1></td>
                </tr>

                <tr>
                    <td><p style="font-size: 18px">成本：</p></td>
                    <td><p style="font-size: 18px;font-weight: bold">￥${sessionScope.food.disprice}.00</p></td>
                </tr>

                <tr>
                    <td><p style="font-size: 18px">点击量：</p></td>
                    <td><p style="font-size: 18px">累计 <span>10000+</span> 次</p></td>
                </tr>

                <tr>
                    <td> <p style="font-size: 18px">评价：</p></td>
                    <td><p style="font-size: 18px">已有 <span>10000+</span> 条评价</p></td>
                </tr>

                <tr>
                    <td> <p style="font-size: 18px">人气：</p></td>
                    <td><p style="font-size: 18px">已有 <span><span >150000</span></span> 人关注</p></td>
                </tr>

                <tr>
                    <td><p style="font-size: 18px">更新：</p></td>
                    <td><p style="font-size: 18px">2020-09-16</p></td>
                </tr>
               <%-- <tr>
                    <td colspan="2"><img src="${pageContext.request.contextPath}/static/crc/images/btn_tobuy.jpg" style="width:120px ;height:35px" >
                    <img src="${pageContext.request.contextPath}/static/crc/images/btn_addcart.jpg" style="width:120px ;height:35px;margin-left: 10px" ></td>
                </tr>--%>
            </table>
        </div>


    </div>
</div>
<hr/>

<div style="background-image:url(../static/crc/images/banner4.jpg);margin:0px auto;width:100%; height:500px;border: 1px solid rgba(255,2,2,0);">

    <div >
        <div >&nbsp;
            <p style="width:25%;margin-top:120px;margin-left:100px;font-size: 30px;"><font  color="#fffff">
                <font color="red">这就是菜谱：</font>
                ${sessionScope.food.oper}
                <br/>
                <br/>
            </font></p>
        </div>
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
</html>
