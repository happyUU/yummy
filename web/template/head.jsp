<%--
  Created by IntelliJ IDEA.
  User: LuckyH
  Date: 2020/9/14
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":"
            + request.getServerPort() + request.getContextPath();

    pageContext.setAttribute("basePath", basePath);
%>

<base href="<%=basePath%>" />

<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css" type="text/css" />--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/hqx/css/bootstrap.min.css" type="text/css" />
<script src="${pageContext.request.contextPath}/static/hqx/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/hqx/js/bootstrap.min.js"></script>

