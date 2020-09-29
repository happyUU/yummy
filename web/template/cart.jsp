<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/14
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
    <%@ include file="/template/head.jsp"%>
    <script src="${pageContext.request.contextPath}/static/hqx/js/cart.js"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/public.js"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/pro.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/proList.css"/>
</head>
<body>
<div class="container">
    <%--    <c:if test="${empty sessionScope.cart}">--%>
    <%--        购物车为空--%>
    <%--    </c:if>--%>
    <%--    <c:if test="${!empty sessionScope.cart}">--%>
    <%--        <c:forEach items="${sessionScope.cart.items}" var="cartItem">--%>
    <%--            ${cartItem}<br>--%>
    <%--        </c:forEach>--%>
    <%--    </c:if>--%>
    <%--    <br>--%>
    <%--    ${sessionScope.cart}--%>

    <%--    <br>--%>
    <%--    <a href="${pageContext.request.contextPath}/pages/shopping.jsp" >返回购物</a>--%>
    <%--    <div class="head ding">--%>
    <%--        <div class="wrapper clearfix">--%>
    <%--            <div class="clearfix" id="top">--%>
    <%--                <h1 class="fl">--%>
    <%--                    <a href="${pageContext.request.contextPath}/index.jsp">--%>
    <%--                        <img src="${pageContext.request.contextPath}/static/img/logo.png"/></a>--%>
    <%--                </h1>--%>
    <%--                <div class="fr clearfix" id="top1">--%>
    <%--                    <p class="fl">--%>
    <%--                        <a href="#" id="login">登录</a>--%>
    <%--                        <a href="#" id="reg">注册</a>--%>
    <%--                    </p>--%>
    <%--                    <form action="#" method="get" class="fl">--%>
    <%--                        <input type="text" placeholder="搜索"/><input type="button"/>--%>
    <%--                    </form>--%>
    <%--                    <div class="btn fl clearfix">--%>
    <%--                        <a href="#"><img src="${pageContext.request.contextPath}/static/img/grzx.png"/></a>--%>
    <%--                        <a href="#" class="er1"><img src="${pageContext.request.contextPath}/static/img/ewm.png"/></a>--%>
    <%--                        <a href="#"><img src="${pageContext.request.contextPath}/static/img/gwc.png"/></a>--%>
    <%--                        <p><a href="#"><img src="${pageContext.request.contextPath}/static/img/smewm.png"/></a></p>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <ul class="clearfix" id="bott">--%>
    <%--                <li><a href="#">首页</a></li>--%>
    <%--                <li><a href="#">所有商品</a>--%>
    <%--                    <div class="sList">--%>
    <%--                        <div class="wrapper  clearfix">--%>
    <%--                            <a href="#"><dl>--%>
    <%--                                <dt><img src="${pageContext.request.contextPath}/static/img/nav1.jpg"/></dt>--%>
    <%--                                <dd>浓情欧式</dd>--%>
    <%--                            </dl></a>--%>
    <%--                            <a href="#"><dl>--%>
    <%--                                <dt><img src="${pageContext.request.contextPath}/static/img/nav2.jpg"/></dt>--%>
    <%--                                <dd>浪漫美式</dd>--%>
    <%--                            </dl></a>--%>
    <%--                            <a href="#"><dl>--%>
    <%--                                <dt><img src="${pageContext.request.contextPath}/static/img/nav3.jpg"/></dt>--%>
    <%--                                <dd>雅致中式</dd>--%>
    <%--                            </dl></a>--%>
    <%--                            <a href="#"><dl>--%>
    <%--                                <dt><img src="${pageContext.request.contextPath}/static/img/nav6.jpg"/></dt>--%>
    <%--                                <dd>简约现代</dd>--%>
    <%--                            </dl></a>--%>
    <%--                            <a href="#"><dl>--%>
    <%--                                <dt><img src="${pageContext.request.contextPath}/static/img/nav7.jpg"/></dt>--%>
    <%--                                <dd>创意装饰</dd>--%>
    <%--                            </dl></a>--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                </li>--%>
    <%--                <li><a href="flowerDer.html">装饰摆件</a>--%>
    <%--                    <div class="sList2">--%>
    <%--                        <div class="clearfix"><a href="proList.html">干花花艺</a><a href="vase_proList.html">花瓶花器</a></div>--%>
    <%--                    </div>--%>
    <%--                </li>--%>
    <%--                <li><a href="decoration.html">布艺软饰</a>--%>
    <%--                    <div class="sList2">--%>
    <%--                        <div class="clearfix"><a href="zbproList.html">桌布罩件</a><a href="bzproList.html">抱枕靠垫</a></div>--%>
    <%--                    </div>--%>
    <%--                </li>--%>
    <%--                <li><a href="paint.html">墙式壁挂</a></li>--%>
    <%--                <li><a href="perfume.html">蜡艺香薰</a></li>--%>
    <%--                <li><a href="idea.html">创意家居</a></li>--%>
    <%--            </ul>--%>
    <%--        </div>--%>
    <%--    </div>--%>
    <div class="cart mt"><!-----------------logo------------------->
        <!--<div class="logo"><h1 class="wrapper clearfix"><a href="index.html"><img class="fl" src="img/temp/logo.png"></a><img class="top" src="img/temp/cartTop01.png"></h1></div>-->
        <!-----------------site------------------->
        <div class="site">
            <p class=" wrapper clearfix">
                <span class="fl">购物车</span>
                <img class="top" src="${pageContext.request.contextPath}/static/hqx/img/temp/cartTop01.png">
                <a href="${pageContext.request.contextPath}/template/shopping.jsp" class="fr">继续购物&gt;</a>
            </p>
        </div><!-----------------table------------------->
        <div class="table wrapper" id="cart_table">
            <div class="th" id="cart_table_head">
                <div>商品</div>
                <div>单价</div>
                <div>数量</div>
                <div>小计</div>
                <div>操作</div>
            </div>


            <div class="th clearfix">
                <label class="fl"><input id="check_all_checkbox" type="checkbox"/><span></span></label>
                <p class="fl">
                    <button type="button" class="btn btn-link" id="check_all_btn">全选</button>
                    <button type="button" class="btn btn-link delete_checked_btn">删除</button></p>
                <p class="fr">
                    <span>已选中共<small id="cart_total_count">0</small>件商品</span>
                    <span>合计:&nbsp;<small id="cart_total_price">￥0.00</small></span>
                    <button type="button" class="btn btn-link" id="count_cart_btn" disabled="disabled">结算</button>
                </p>
            </div>
        </div>
    </div>

    <div class="mask"></div>
    <div class="tipDel"><p>确定要删除该商品吗？</p>
        <p class="clearfix">
            <a class="fl cer" href="#">确定</a>
            <a class="fr cancel" href="#">取消</a></p>
    </div>
    <!--返回顶部-->

    <%@ include file="/template/footer.jsp"%>

    <!----------------mask------------------->
    <%--<div class="mask"></div><!-------------------mask内容------------------->
    <div class="proDets">
        <img class="off" src="${pageContext.request.contextPath}/static/hqx/img/temp/off.jpg"/>
        <div class="proCon clearfix">
            <div class="proImg fr">
                <img class="list" src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet.jpg"/>
                <div class="smallImg clearfix">
                    <img src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet01.jpg" data-src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet01_big.jpg">
                    <img src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet02.jpg" data-src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet02_big.jpg">
                    <img src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet03.jpg" data-src="${pageContext.request.contextPath}/static/hqx/img/temp/proDet04_big.jpg">
                </div>
            </div>
            <div class="fl">
                <div class="proIntro change">
                    <p>颜色分类</p>
                    <div class="smallImg clearfix">
                        <p class="fl on">
                            <img src="${pageContext.request.contextPath}/static/hqx/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花" data-src="img/temp/proBig01.jpg">
                        </p>
                        <p class="fl">
                            <img src="${pageContext.request.contextPath}/static/hqx/img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草" data-src="img/temp/proBig02.jpg">
                        </p>
                        <p class="fl">
                            <img src="${pageContext.request.contextPath}/static/hqx/img/temp/prosmall03.jpg" alt="20支快乐花" data-src="img/temp/proBig03.jpg">
                        </p>
                        <p class="fl">
                            <img src="${pageContext.request.contextPath}/static/hqx/img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="img/temp/proBig04.jpg">
                        </p>
                    </div>
                </div>
                <div class="changeBtn clearfix"><a href="#2" class="fl"><p class="buy">确认</p></a><a href="#2" class="fr"><p
                        class="cart">取消</p></a></div>
            </div>
        </div>
    </div>
    <div class="pleaseC">
        <p>请选择宝贝</p>
        <img class="off" src="${pageContext.request.contextPath}/static/hqx/img/temp/off.jpg"/>
    </div>--%>
</div>

<%@ include file="/template/gotop.jsp"%>

</body>
</html>
