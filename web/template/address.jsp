<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/22
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Address</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/hqx/css/mygxin.css"/>
    <script src="${pageContext.request.contextPath}/static/hqx/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/public.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/user.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/hqx/js/address.js"></script>
</head>
<body>
<%--<div class="head ding">--%>
<%--    <div class="wrapper clearfix">--%>
<%--        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>--%>
<%--            <div class="fr clearfix" id="top1"><p class="fl"><a href="login.html" id="login">登录</a><a href="reg.html"--%>
<%--                                                                                                      id="reg">注册</a>--%>
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
        <a href="#" class="fl">首页</a><span>/</span>
        <a href="#">个人中心</a><span>/</span>
        <a href="#" class="on">地址管理</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <%@ include file="myMenuList.jsp"%>
        <div class="you fl">
            <h2>收货地址</h2>
            <div class="add user_address_list">
                <div><a href="#2" class="add_addr_btn"><img src="${pageContext.request.contextPath}/static/hqx/img/jia.png"/></a><span>添加新地址</span></div>
<%--                <div class="dizhi">--%>
<%--                    <p>六六六</p>--%>
<%--                    <p>1573****666</p>--%>
<%--                    <p>河北省 唐山市 路北区</p>--%>
<%--                    <p>唐山市大学生公寓村（063000）</p>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</div><!--编辑弹框--><!--遮罩-->
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
<%@ include file="gotop.jsp"%>
<!--footer-->
<%@ include file="footer.jsp"%>
</body>
</html>
