
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>菜谱大全</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/static/crc/css/recipe.css" />
</head>

<script src="${pageContext.request.contextPath}/static/crc/js/jquery-3.2.1.js"></script>
<script type="text/javascript">


    function dotypename(val){

        $.ajax({
            url : "querybytypename.do",
            type : "POST",
            data : {
                "name" : val
            },
            dataType : "json",
            success : function(data) {
                //console.log(data);

                for (var i = 0; i < data.length; i++) {
                    console.log(data[i].dispic);

                }
                window.location.reload();//重新加载

            }


        })
    }


</script>
<body>

<%--<c:forEach items="${sessionScope.allfoods}" var="food">

    <tr>
        <td> <img src="static/图片/${food.dispic}" width="100px" height="100px"></td>
        <br/>
        <td>${food.describe}</td>
        <br/>
        <td>${food.typename}</td>
        <br/>

    <tr/>

</c:forEach>--%>
<!-- 导航条 -->

<nav>
    <img src="${pageContext.request.contextPath}/static/crc/images/logo2.png" alt="美食食尚" title="美食食尚" id="logo" />
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
<!-- 主体部分 -->
<div id="back_img">
    <div id="img_food">甄选地道食材， 刺激您的味蕾</div>
    <div id="img_Eng">Selection of authenlic ingredients, moving your taste buds.</div>
</div>
<!-- <script src="main.js"></script> -->


<div id="food_type">
    <div class="ul_type"><p style="font-size: 20px;">经典菜系</p>
        <ul class="food_ul">
            <li class="food_name"><input type="button" name="sel" value="川菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="鲁菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="粤菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="苏菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="浙菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="闽菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="湘菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="徽菜" class="food_name_button"></li>
        </ul>
    </div>
    <div class="ul_type"><p style="font-size: 20px;">西式菜系</p>
        <ul class="food_ul">
            <li class="food_name"><input type="button" name="sel" value="日本料理" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="韩国料理" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="意大利菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="法国料理" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="墨西哥菜" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="德国料理" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="埃及美食" class="food_name_button"></li>
            <li class="food_name"><input type="button" name="sel" value="中东美食" class="food_name_button"></li>
        </ul>
    </div>
</div>
<div id="food_show">
    <h1>Meal Of Today</h1>
    <ul id="example">
        <li class="exam_message">
            <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food1.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/1.jpg';this.onerror=null"/>
            <h1><a href="${pageContext.request.contextPath}/foodcp.do?method=${sessionScope.food1.dishid}">${sessionScope.food1.disname}</a></h1>
            <p>${sessionScope.food1.describe}</p>
           <%-- <button>我喜欢</button>--%>

        </li>
        <li class="exam_message">
            <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food2.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/2.jpg';this.onerror=null"/>
            <h1><a href="${pageContext.request.contextPath}/foodcp.do?method=${sessionScope.food2.dishid}">${sessionScope.food2.disname}</a></h1>
            <p>${sessionScope.food2.describe}</p>
            <%--<button>我喜欢</button>--%>


        </li>
        <li class="exam_message">
            <img src="${pageContext.request.contextPath}/static/crc/foodimages/${sessionScope.food3.dispic}" alt="美食" onerror="this.src='${pageContext.request.contextPath}/static/crc/images/3.jpg';this.onerror=null"/>
            <h1><a href="${pageContext.request.contextPath}/foodcp.do?method=${sessionScope.food3.dishid}">${sessionScope.food3.disname}</a></h1>
            <p>${sessionScope.food3.describe}</p>
           <%-- <button>我喜欢</button>--%>


        </li>


    </ul>
</div>
<div id="the_food">
    <div id="the_title">The Food</div>
    <p>通俗认为，供人类或动物食用的可消化的物质称为食物。根据黎黍匀专家的定义，认为食物是指能够满足机体正常生理和生化需求，并能够延续正常寿命的物质。对人体而言，能够满足人的正常活动需求并利于寿命延长的物质称为食物。一般食物定义：是指能被食用并经消化吸收后构成机体供给活动所需能量或调节生理机能的无毒物质。</p>
</div>
<div id="cake_show">
    <div id="black_cake">
        <div id="black_title">DELCIOUS</div>
        <ul id="ul_1">
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake1.jpg" alt="蛋糕">
            </li>
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake2.jpg" alt="蛋糕">
            </li>
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake3.jpg" alt="蛋糕">
            </li>
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake4.jpg" alt="蛋糕">
            </li>
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake5.jpg" alt="蛋糕">
            </li>
        </ul>
        <ul id="ul_2">
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake6.jpg" alt="蛋糕">
            </li>
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake7.jpg" alt="蛋糕">
            </li>
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake8.jpg" alt="蛋糕">
            </li>
        </ul>
        <ul id="ul_3">
            <li class="cake">
                <img src="${pageContext.request.contextPath}/static/crc/images/cake9.jpg" alt="蛋糕">
            </li>
        </ul>
    </div>
    <div id="white_cake">
        <div class="pretty_cake" id="pre_1"><img src="${pageContext.request.contextPath}/static/crc/images/cake11.jpg" alt="蛋糕"></div>
        <div class="pretty_cake" id="pre_2"><img src="${pageContext.request.contextPath}/static/crc/images/cake22.jpg" alt="蛋糕"></div>
        <div class="pretty_cake" id="pre_3"><img src="${pageContext.request.contextPath}/static/crc/images/cake33.jpg" alt="蛋糕"></div>
        <div class="pretty_cake" id="pre_4"><img src="${pageContext.request.contextPath}/static/crc/images/cake44.jpg" alt="蛋糕"></div>
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
</body>
<script>
    let element = document.getElementsByName("sel");
    for (let i = 0; i < element.length; i++) {
        element[i].onclick = function() {

            var str=this.value
            //alert(str)
            dotypename(str);
        }

    }
</script>
</html>
