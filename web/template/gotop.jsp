<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/17
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="gotop">
    <a href="${pageContext.request.contextPath}/template/cart.jsp">
        <dl>
            <dt style="display: block;"><img src="${pageContext.request.contextPath}/static/hqx/img/gt1.png"></dt>
            <dd style="display: none;">去购<br>物车</dd>
        </dl>
    </a>
    <a href="#" class="dh">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/static/hqx/img/gt2.png"></dt>
            <dd>联系<br>客服</dd>
        </dl>
    </a>
    <a href="${pageContext.request.contextPath}/template/myorderq.jsp">
        <dl>
            <dt><img src="${pageContext.request.contextPath}/static/hqx/img/gt3.png"></dt>
            <dd>个人<br>中心</dd>
        </dl>
    </a>
    <p style="display: none; left: -130px;">400-800-8200</p>
</div>
