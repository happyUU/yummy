<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/16
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Order</title>
    <%@ include file="/template/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/mygxin.css "/>
    <script src="${pageContext.request.contextPath}/static/hqx/js/jquery-3.3.1.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/public.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/pro.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/user.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/order.js"></script>
</head>
<body>
<%--<div class="head ding">--%>
<%--    <div class="wrapper clearfix">--%>
<%--        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>--%>
<%--            <div class="fr clearfix" id="top1"><p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>--%>
<%--            </p>--%>
<%--                <form action="#" method="get" class="fl"><input type="text" placeholder="搜索"/><input type="button"/>--%>
<%--                </form>--%>
<%--                <div class="btn fl clearfix"><a href="mygxin.html"><img src="img/grzx.png"/></a><a href="#" class="er1"><img--%>
<%--                        src="img/ewm.png"/></a><a href="cart.html"><img src="img/gwc.png"/></a>--%>
<%--                    <p><a href="#"><img src="img/smewm.png"/></a></p></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <ul class="clearfix" id="bott">--%>
<%--            <li><a href="index.html">首页</a></li>--%>
<%--            <li><a href="#">所有商品</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="paint.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/nav1.jpg"/></dt>--%>
<%--                            <dd>浓情欧式</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="paint.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/nav2.jpg"/></dt>--%>
<%--                            <dd>浪漫美式</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="paint.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/nav3.jpg"/></dt>--%>
<%--                            <dd>雅致中式</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="paint.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/nav6.jpg"/></dt>--%>
<%--                            <dd>简约现代</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="paint.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/nav7.jpg"/></dt>--%>
<%--                            <dd>创意装饰</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="flowerDer.html">装饰摆件</a>--%>
<%--                <div class="sList2">--%>
<%--                    <div class="clearfix"><a href="proList.html">干花花艺</a><a href="vase_proList.html">花瓶花器</a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="decoration.html">布艺软饰</a>--%>
<%--                <div class="sList2">--%>
<%--                    <div class="clearfix"><a href="zbproList.html">桌布罩件</a><a href="bzproList.html">抱枕靠垫</a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="paint.html">墙式壁挂</a></li>--%>
<%--            <li><a href="perfume.html">蜡艺香薰</a></li>--%>
<%--            <li><a href="idea.html">创意家居</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="order cart mt"><!-----------------site------------------->
    <div class="site"><p class="wrapper clearfix">
        <span class="fl">订单确认</span>
        <img class="top" src="${pageContext.request.contextPath}/static/hqx/img/temp/cartTop02.png"></p>
    </div><!-----------------orderCon------------------->
    <div class="orderCon wrapper clearfix">
        <div class="orderL fl"><!--------h3---------------->
            <h3>收件信息
                <button type="button" class="btn btn-link fr add_addr_btn">新增地址</button>
            </h3>
            <!--------addres---------------->
            <div class="addres clearfix address_panel">

                <%--                <div class="addre fl on">--%>
                <%--                    <div class="tit clearfix">--%>
                <%--                        <p class="fl">张三1 <span class="default">[默认地址]</span></p>--%>
                <%--                        <p class="fr"><a href="#">删除</a><span>|</span><a href="#" class="edit">编辑</a></p>--%>
                <%--                    </div>--%>
                <%--                    <div class="addCon">--%>
                <%--                        <p>河北省 唐山市 路北区 大学生公寓村</p>--%>
                <%--                        <p>15732570937</p>--%>
                <%--                    </div>--%>
                <%--                </div>--%>

            </div>
            <h3>支付方式</h3><!--------way---------------->
            <div class="way clearfix">
                <img class="on" src="${pageContext.request.contextPath}/static/hqx/img/temp/way01.jpg">
                <img src="${pageContext.request.contextPath}/static/hqx/img/temp/way02.jpg">
                <img src="${pageContext.request.contextPath}/static/hqx/img/temp/way03.jpg">
                <img src="${pageContext.request.contextPath}/static/hqx/img/temp/way04.jpg">
            </div>
        </div>
        <div class="orderR fr">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>订单内容
                        <a href="${pageContext.request.contextPath}/template/cart.jsp" class="fr">返回购物车</a>
                    </h3>
                </div>
                <div class="panel-body order_items_panel">

                </div>
            </div>
            <!--------tips---------------->
            <div class="tips">
                <p>
                    <span class="fl">商品金额：</span>
                    <span class="fr" id="total_price"></span>
                </p>
                <p>
                    <span class="fl">优惠金额：</span>
                    <span class="fr" id="discount_price"></span>
                </p>
                <p>
                    <span class="fl">运费：</span>
                    <span class="fr">免运费</span>
                </p>
            </div><!--------tips count---------------->
            <div class="count tips">
                <p>
                    <span class="fl">合计：</span>
                    <span class="fr" id="pay_total_price">￥139.80</span>
                </p>
            </div>
            <button type="button" class="btn-link btn pay pay_btn">去支付</button></div>
    </div>
</div>
<!--编辑弹框--><!--遮罩-->
<div class="mask"></div>
<div class="adddz editAddre" id="update_addr_modal">
    <form action="" method="get">
        <input type="hidden" name="addr_id" class="addr_id" />
        <input type="text" name="addr_name" class="addr_name" placeholder="姓名"/>
        <input type="text" name="addr_phone" class="addr_phone" placeholder="手机号"/>
        <div class="city user_address">
            <select name="addr_province" class="addr_select addr_province">

            </select>
            <select name="addr_city" class="addr_select addr_city">

            </select>
            <select name="addr_county" class="addr_select addr_county">

            </select>
        </div>
        <textarea name="addr_detail" class="addr_detail" rows="" cols="" placeholder="详细地址"></textarea>
        <div class="bc">
            <input type="button" id="mask_update_btn" value="保存"/>
            <input type="button" class="mask_cancel" value="取消"/>
        </div>
    </form>
</div>
<div class="adddz add_addr">
    <form action="" method="get">
        <input type="text" name="addr_name" class="addr_name" placeholder="姓名"/>
        <input type="text" name="addr_phone" class="addr_phone" placeholder="手机号"/>
        <div class="city user_address">
            <select name="addr_province" class="addr_select addr_province">

            </select>
            <select name="addr_city" class="addr_select addr_city">

            </select>
            <select name="addr_county" class="addr_select addr_county">

            </select>
        </div>
        <textarea name="addr_detail" class="addr_detail" rows="" cols="" placeholder="详细地址"></textarea>
        <div class="bc">
            <input type="button" id="mask_save_btn" value="保存"/>
            <input type="button" class="mask_cancel" value="取消"/>
        </div>
    </form>
</div><!--返回顶部-->
<%@include file="/template/gotop.jsp" %>
<%@include file="/template/footer.jsp" %>
</body>
</html>
