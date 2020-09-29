<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>index</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/xsr/css/index.css" />
  <!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
       crossorigin="anonymous">-->
</head>

<body>
<!-- 网页头部 -->
<div id="main_header">
  <!-- 导航条 -->
  <nav>
    <img src="${pageContext.request.contextPath}/static/xsr/images/logo2.png" alt="美食食尚" title="美食食尚" id="logo" />
    <ul id="title">
      <li class="pageName">
        <a href="${pageContext.request.contextPath}/index.jsp">首页</a>
      </li>
      <li class="pageName">
        <a href="${pageContext.request.contextPath}/template/recipe.jsp">菜谱大全</a>
      </li>
      <%--<li class="pageName">
        <a href="${pageContext.request.contextPath}/template/dining.jsp">每日推荐</a>
      </li>--%>
      <li class="pageName">
          <a href="${pageContext.request.contextPath}/queryhallall.do">呀咪餐厅</a>
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
  <!-- 轮播图 -->
  <header>
    <div id="website_introduce">
      <div id="intro_1">FOOD FASHION</div>
      <div id="intro_2">DESIGN 美食食尚</div>
      <div id="intro_3">FOOD IS INDISPENSABLE TO EVERYONE IN THE LIFE.ENJOY LIFE TON ENJOY FOOD</div>
    </div>
  </header>
</div>
<!-- 网页主体 -->
<div id="main_body">
  <!-- 我们的产品 -->
  <div id="product">
    <!-- <div class="dinyName">我们的产品</div> -->
    <ul id="dish">
      <li class="dish_introduce">
        <img src="${pageContext.request.contextPath}/static/xsr/images/1.jpg" alt="图片正在加载" class="dish_picture">
        <div class="dish_text">
          <div class="text_1">菜系让人屡试不爽</div>
          <div class="text_1">Seafood new</div>
          <div class="text_3"></div>
          <div class="text_1">鲜活味美，品种繁多</div>
          <div class="text_5">无污染环境营养价值高</div>
        </div>
      </li>
      <li class="dish_introduce">
        <img src="${pageContext.request.contextPath}/static/xsr/images/2.jpg" alt="图片正在加载" class="dish_picture">
        <div class="dish_text">
          <div class="text_1">菜系让人屡试不爽</div>
          <div class="text_1">Seafood new</div>
          <div class="text_3"></div>
          <div class="text_1">鲜活味美，品种繁多</div>
          <div class="text_5">无污染环境营养价值高</div>
        </div>
      </li>
      <li class="dish_introduce">
        <img src="${pageContext.request.contextPath}/static/xsr/images/3.jpg" alt="图片正在加载" class="dish_picture">
        <div class="dish_text">
          <div class="text_1">菜系让人屡试不爽</div>
          <div class="text_1">Seafood new</div>
          <div class="text_3"></div>
          <div class="text_1">鲜活味美，品种繁多</div>
          <div class="text_5">无污染环境营养价值高</div>
        </div>
      </li>
    </ul>
  </div>
  <!-- 我们的新闻 -->
  <div id="our_news">
    <!-- <div class="dinyName">我们的新闻</div> -->
    <div id="cate">
      <img src="${pageContext.request.contextPath}/static/xsr/images/news.jpg" alt="图片正在加载">
      <div id="img_introduce">
        <div id="today_data">六月/20 Monday</div>
        <div id="date_line"></div>
        <div id="clear"></div>
        <div id="today_text">
          <h3>人生中不可缺少的美食描述</h3>
          <p>那些冰糖葫芦红彤彤的，在阳光的照耀下闪闪发光，不知引来多少小孩儿渴求的目光。妈妈熬的鸡汤，白色的，很香，咸味，很好喝。每次妈妈做鸡汤，我都拿个小勺子喝，喝一口，品品味，再咽下去，再喝一口，再品品味，再咽下去······小馄饨，个小，皮薄，只要往开水中一捞，就能盛入碗中，在吃上一口，好鲜美！</p>
          <div class="star">
            <i class="far fa-thumbs-up"></i>
            <span>2222</span>
          </div>
          <div class="star">
            <i class="far fa-heart"></i>
            <span>2222</span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 联系我们 -->
  <div id="call_us">
    <div class="dinyName" id="contract_us">联系我们</div>
    <ul id="per_ul">
      <li class="person">
        <img src="${pageContext.request.contextPath}/static/xsr/images/aj.jpg" alt="" class="person_pic" />
        <div class="per_mess">Luma</div>
        <div class="per_mess">北京市朝阳区小庄金台西路8号</div>
        <div class="per_mess">367-556-8777</div>
      </li>
      <li class="person">
        <img src="${pageContext.request.contextPath}/static/xsr/images/ak.jpg" alt="" class="person_pic" />
        <div class="per_mess">Anna</div>
        <div class="per_mess">北京市朝阳区小庄金台西路8号</div>
        <div class="per_mess">367-556-8777</div>
      </li>
      <li class="person">
        <img src="${pageContext.request.contextPath}/static/xsr/images/al.jpg" alt="" class="person_pic" />
        <div class="per_mess">Li Lin</div>
        <div class="per_mess">北京市朝阳区小庄金台西路8号</div>
        <div class="per_mess">367-556-8777</div>
      </li>
    </ul>
    <div id="position">
      <img src="${pageContext.request.contextPath}/static/xsr/images/position_arr.png" alt="">
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
</div>
</body>
<script src="${pageContext.request.contextPath}/static/xsr/js/index.js"></script>

</html>