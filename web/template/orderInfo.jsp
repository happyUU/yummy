<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/20
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OrderInfo</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/myorder.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/public.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/js/user.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/js/orderInfo.js"></script>
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
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix">
        <a href="index.html" class="fl">首页</a><span>/</span>
        <a href="myorderq.html" class="on">我的订单</a><span>/</span><a
            href="#" class="on">订单详情</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <%@ include file="/pages/common/myMenuList.jsp"%>
        <div class="you fl">
            <div class="my clearfix">
                <h2>订单详情<a href="#">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></h2>
                <h3>订单号：<span class="order_id"></span></h3>
            </div>
            <div class="orderList">
                <div class="orderList1 item_list_info">
<%--                    <h3>已收货</h3>--%>
<%--                    <div class="clearfix order_item_info">--%>
<%--                        <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/img/g1.jpg"/></a>--%>
<%--                        <p class="fl">--%>
<%--                            <a href="#">家用创意菜盘子圆盘 釉下彩复古</a>--%>
<%--                            <a href="#">¥99.00×1</a>--%>
<%--                        </p>--%>
<%--                    </div>--%>
                </div>
                <div class="orderList1 user_address">

<%--                <div class="orderList1">--%>
<%--                    <h3>支付方式及送货时间</h3>--%>
<%--                    <p>支付方式：<span>在线支付</span></p>--%>
<%--                    <p>送货时间：<span>不限送货时间</span></p></div>--%>
                </div>
                <div class="orderList1 hei order_count">
<%--                    <h3><strong>商品总价：</strong><span>¥99</span></h3>--%>
<%--                    <p><strong>运费：</strong><span>¥0</span></p>--%>
<%--                    <p><strong>订单金额：</strong><span>¥99</span></p>--%>
<%--                    <p><strong>实付金额：</strong><span>¥99</span></p></div>--%>
                </div>
            </div>
        </div>
    </div>
</div>
<<!--返回顶部-->
<%@ include file="/pages/common/gotop.jsp"%>
    <!--footer-->
<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>
