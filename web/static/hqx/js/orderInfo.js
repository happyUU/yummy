//获取当前网址，如： http://localhost:8080/yummy/index.jsp
var curPath = window.document.location.href;
//获取主机地址之后的目录，如： yummy/index.jsp
var pathName = window.document.location.pathname;
var pos = curPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8080
var localhostPath = curPath.substring(0, pos);
//获取带"/"的项目名，如：/yummy
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

const basePath = localhostPath + projectName;

$(function(){
    var parameters = getParameters();
    if(parameters.orderId !== undefined){
        $.ajax({
            url: basePath + '/getOrderInfo.order',
            data: {
                'orderId':parameters.orderId
            },
            success: function (result) {
                result = jsonStringToObj(result);
                console.log(result);
                showOrderInfo(result);
            }
        })
    }
})
//                      <h3>已收货</h3>
//                     <div class="clearfix order_item_info">
//                         <a href="#" class="fl"><img src="${pageContext.request.contextPath}/static/img/g1.jpg"/></a>
//                         <p class="fl">
//                             <a href="#">家用创意菜盘子圆盘 釉下彩复古</a>
//                             <a href="#">¥99.00×1</a>
//                         </p>
//                     </div>
function showOrderInfo(order) {
    $('.order_id').append(order.orderId);
    var parentNode = $('.item_list_info').append($('<h3>' + parseOrderStatue(order.orderStatue) + '</h3>'));
    showOrderItemsInfo(order.orderItems, parentNode);
    $('.user_address').append($(' <h3>收货信息</h3>\n' +
        '                    <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<span>' + order.receivingName + '</span></p>\n' +
        '                    <p>联系电话：<span>' + order.receivingPhone + '</span></p>\n' +
        '                    <p>收货地址：<span>' + order.receivingAddr + '</span></p></div>'));
    $('.order_count').append($('<h3><strong>商品总价：</strong><span>¥' + parseFloat(order.itemTotalPrice).toFixed(2) + '</span></h3>\n' +
        '                    <p><strong>运费：</strong><span>¥' + parseFloat(order.orderCarriage).toFixed(2) + '</span></p>\n' +
        '                    <p><strong>订单金额：</strong><span>¥' + parseFloat(order.orderPrice).toFixed(2) + '</span></p>\n' +
        '                    <p><strong>实付金额：</strong><span>¥' + parseFloat(order.actuallyPaid).toFixed(2) + '</span></p></div>'));
}

function showOrderItemsInfo(items, parentNode) {
    var panel = $('<div class="items_panel"></div>');
    console.log(items);
    $.each(items, function () {
        $('                    <div class="clearfix order_item_info">\n' +
            '                        <a href="#" class="fl"><img src="' + basePath + this.img_path + '"/></a>\n' +
            '                        <p class="fl">\n' +
            '                            <a href="#">' + this.itemName + '</a>\n' +
            '                            <a href="#">¥' + parseFloat(this.itemPrice).toFixed(2) + '×' + this.itemCount + '</a>\n' +
            '                        </p>\n' +
            '                    </div>').appendTo(panel);
    })
    parentNode.append(panel);

}

function parseOrderStatue(statue) {
    var statueStr = "";
    if (statue === 100) {
        statueStr = '待支付';
        // orderAction.append('去付款');
        // orderAction.click(function () {
        //     //alert('success');
        // })
    } else if (statue === 200) {
        statueStr = "待发货";
        // orderAction.append('确认收货');
    } else if (statue === 300) {
        statueStr = "待签收";
        // orderAction.append('确认收货');
    } else if (statue === 400) {
        statueStr = "已签收";
        // orderAction.append('确认收货');
    } else if (statue === 500) {
        // parentNode.removeClass('deng');
        statueStr = "已关闭";
        // orderAction.append('交易关闭');
    } else if (statue === 600) {
        // parentNode.removeClass('deng');
        statueStr = "已完成";
        // orderAction.append('交易成功');
    }
    return statueStr;
}

function getParameters() {
//返回当前 URL 的查询部分（问号 ? 之后的部分）。
    var urlParameters = location.search;
    //声明并初始化接收请求参数的对象
    var requestParameters = {};
    //如果该求青中有请求的参数，则获取请求的参数，否则打印提示此请求没有请求的参数
    if (urlParameters.indexOf('?') !== -1) {
        //获取请求参数的字符串
        var parameters = decodeURI(urlParameters.substr(1));
        //将请求的参数以&分割中字符串数组
        var parameterArray = parameters.split('&');
        //循环遍历，将请求的参数封装到请求参数的对象之中
        for (var i = 0; i < parameterArray.length; i++) {
            requestParameters[parameterArray[i].split('=')[0]] = (parameterArray[i].split('=')[1]);
        }
        console.info('theRequest is =====', requestParameters);
    } else {
        console.info('There is no request parameters');
    }
    console.log(requestParameters.orderId);
    return requestParameters;
}


function jsonStringToObj(result) {
    if (typeof result == "string") {
        return eval('(' + result + ')');
    }
}