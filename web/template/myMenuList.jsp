<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/22
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="zuo fl">
    <h3>
        <a href="#"><img src="${pageContext.request.contextPath}/static/hqx/img/tx.png"/></a>
        <p class="clearfix">
            <span class="fl">${sessionScope.username}</span>
            <span class="fr"><a style="color: gray;text-decoration: none" href="${pageContext.request.contextPath}/cancel.action">[退出登录]</a></span>
    </h3>
    <div><h4>我的交易</h4>
        <ul>
            <li><a href="${pageContext.request.contextPath}/template/cart.jsp">我的购物车</a></li>
            <li class="on"><a href="${pageContext.request.contextPath}/template/myorderq.jsp">我的订单</a></li>
        </ul>
        <h4>个人中心</h4>
        <ul>
            <li><a href="${pageContext.request.contextPath}/template/user.jsp">我的中心</a></li>
            <li><a href="${pageContext.request.contextPath}/template/address.jsp">地址管理</a></li>
        </ul>
        <%--<h4>账户管理</h4>
        <ul>
            <li><a href="${pageContext.request.contextPath}/template/user.jsp">个人信息</a></li>
            <li><a href="${pageContext.request.contextPath}/template/updateMess.jsp">修改密码</a></li>
        </ul>--%>
    </div>
</div>
