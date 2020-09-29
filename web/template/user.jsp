<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/17
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>用户中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/mygxin.css"/>

</head>
<body><!------------------------------idea------------------------------>
<div class="address mt" id="add">
    <div class="wrapper clearfix"><a href="${pageContext.request.contextPath}/index.jsp" class="fl">首页</a><span>/</span><a href="#" class="on">个人中心</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="${pageContext.request.contextPath}/static/hqx/img/tx.png"/></a>
                <p class="clearfix">
                    <span class="fl">${sessionScope.user.name}</span><br/>
                    <span class="fr"><a style="color: gray;text-decoration: none" href="${pageContext.request.contextPath}/cancel.action">[退出登录]</a></span>
                </p>
            </h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/template/cart.jsp">我的购物车</a></li>
                    <li><a href="${pageContext.request.contextPath}/template/myorderq.jsp">我的订单</a></li>
                    <%--<li><a href="myprod.html">评价晒单</a></li>--%>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li class="on"><a href="#">我的中心</a></li>
                    <li><a href="${pageContext.request.contextPath}/template/address.jsp">地址管理</a></li>
                </ul>
                <%--<h4>账户管理</h4>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/template/">个人信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/template/updateMess.jsp">修改密码</a></li>
                </ul>--%>
            </div>
        </div>
        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/tx.png"/></a>
                    <p class="fl">
                        <span>${sessionScope.user.name}</span>
                        <a href="${pageContext.request.contextPath}/template/updateMess.jsp?id=${sessionScope.user.phone}">修改个人信息</a>
                        <c:if test="${sessionScope.user.admin>=1}">
                            <a href="${pageContext.request.contextPath}/template/admin.jsp" id="login" >管理员操作</a>
                        </c:if>
                    </p>
                </div>
                <div class="fr">绑定邮箱：${sessionScope.user.email}</div>
            </div>
            <div class="bott">
                <div class="clearfix">
                    <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/gxin1.jpg"/></a>
                    <p class="fl">
                      <span>待支付的订单：<strong>0</strong></span><a href="${pageContext.request.contextPath}/template/myorderq.jsp">查看待支付订单></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/gxin2.jpg"/></a>
                    <p class="fl">
                        <span>待收货的订单：<strong>0</strong></span><a href="${pageContext.request.contextPath}/template/myorderq.jsp">查看待收货订单></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/gxin3.jpg"/></a>
                    <p class="fl">
                        <span>待评价的订单：<strong>0</strong></span><a href="${pageContext.request.contextPath}/template/myprod.jsp">查看待评价订单></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/gxin4.jpg"/></a>
                    <p class="fl">
                        <span>喜欢的商品：<strong>0</strong></span>
                        <a href="#">查看喜欢的商品></a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="${pageContext.request.contextPath}/template/cart.jsp">
    <dl>
        <dt><img src="${pageContext.request.contextPath}/static/hqx/img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="${pageContext.request.contextPath}/static/hqx/img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="${pageContext.request.contextPath}/static/hqx/img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="${pageContext.request.contextPath}/static/hqx/img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div>
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="${pageContext.request.contextPath}/static/hqx/img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="${pageContext.request.contextPath}/static/hqx/js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/hqx/js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/static/hqx/js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>