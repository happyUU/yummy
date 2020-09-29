<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/9/25
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin/css/main.css"/>
    <script>
        function checkAll() {
            obj = document.getElementsByName("userCheck");
            check_val = [];
            var string ;
            for(k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            console.log(check_val);
            window.location.href='deleteAll.admin?deleteList='+check_val;
        }
    </script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="${pageContext.request.contextPath}/template/user.jsp" class="navbar-brand">个人中心</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${pageContext.request.contextPath}/index.jsp">yummy首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="${pageContext.request.contextPath}/template/user.jsp">${sessionScope.user.name}</a></li>
                <li><a href="${pageContext.request.contextPath}/template/updateMess.jsp?id=${sessionScope.user.phone}">修改密码</a></li>
                <li><a style="color: gray;text-decoration: none" href="cancel.action">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath}/queryAll.admin"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/queryAll.dish"><i class="icon-font">&#xe008;</i>菜谱管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>数据备份</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>数据还原</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="${pageContext.request.contextPath}/index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="${pageContext.request.contextPath}/template/addDish.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="#" onclick="checkAll()"><i class="icon-font"></i>批量删除</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose"  type="checkbox"></th>
                            <%--<th>排序</th>--%>
                            <th>账号</th>
                            <th>用户名</th>
                            <th>用户权限</th>
                            <th>邮箱</th>
                            <th>订单数量</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="list" items="${sessionScope.userList}">
                            <tr>
                                <td class="tc"><input name="userCheck" value="${list.phone}" type="checkbox"></td>
                                <td>
                                        ${list.phone}
                                        <%--<input class="common-input sort-input" name="ord[]" value="${list.phone}" type="text">--%>
                                </td>
                                <td title="用户名"><a target="_blank" href="${pageContext.request.contextPath}" title="用户名">${list.name}</a>
                                </td>
                                <td>${list.admin}</td>
                                <td>${list.email}</td>
                                <td>5</td>
                                <td>
                                    <a class="link-update" href="${pageContext.request.contextPath}/template/updateMess.jsp?id=${list.phone}">修改</a>
                                    <a class="link-del" href="${pageContext.request.contextPath}/delete.admin?phone=${list.phone}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page"> ${sessionScope.userList.size()} 条 1/1 页</div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
