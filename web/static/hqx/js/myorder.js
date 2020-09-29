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

$(function () {
    toPage(1, 4);

    $(document).on('click', '.page_action', function () {
        //console.log(this);
        var pageNo = $(this).attr('page');
        var pageSize = 4;
        toPage(pageNo, pageSize);
    })

})

function toPage(pageNo, pageSize) {
    $.ajax({
        url: basePath + '/listOrders.order',
        data: {
            'pageNow': pageNo,
            'pageSize': pageSize
        },
        success: function (result) {
            result = jsonStringToObj(result);
            $('.dkuang').remove();
            showOrders(result.items);
            showPages(result);
        }
    })
}

//              <div class="fenye clearfix pagination">
//                 <a href="#" class="page_controller"><img src="${pageContext.request.contextPath}/static/img/zuo.jpg"/></a>
//                 <a href="#" class="page_num">1</a>
//                 <a href="#" class="page_num">2</a>
//                 <a href="#" class="page_num active">3</a>
//                 <a href="#" class="page_num">4</a>
//                 <a href="#" class="page_num">5</a>
//                 <a href="#" class="page_controller"><img src="${pageContext.request.contextPath}/static/img/you.jpg"/></a>
//             </div>

function showPages(page) {
    console.log(page);
    var pagination = $('.pagination');
    pagination.empty();
    var pageTotal = page.pageCount;
    if(page.pageCount < 5){
        setPage(1, page.pageNow, pagination, pageTotal, pageTotal);
    }else{
        if(page.pageNow < 3){
            setPage(1, page.pageNow, pagination, 5, pageTotal);
        }else if(page.pageNow > page.pageCount - 2){
            setPage(page.pageCount - 4, page.pageNow, pagination,5, pageTotal);
        }else{
            setPage(page.pageNow - 2, page.pageNow, pagination, 5, pageTotal);
        }

    }
    pagination.appendTo('.you');
}

function setPage(begin, pageNow, pagination, pageCount, pageTotal) {
    var prePage = (pageNow - 1) > 1? (pageNow - 1) : 1;
    $('<a class="page_action page_controller" page="' + prePage + '"><img src="' + basePath + '/static/hqx/img/zuo.jpg"/></a>').appendTo(pagination);
    for(var i = begin; i < begin + pageCount; i++){
        var pageNum = $('<a class="page_action page_num" page="' + i + '">' + i + '</a>');
        if (pageNow === i){
            pageNum.addClass('active');
        }
        pageNum.appendTo(pagination);
    }
    var endPage = (pageNow + 1) > pageTotal ? pageTotal : (pageNow + 1);
    $('<a class="page_action page_controller" page="' + endPage + '"><img src="' + basePath + '/static/hqx/img/you.jpg"/></a>').appendTo(pagination);

}

function showOrderAction(item) {

}

function showOrderItems(items, parentNode) {
    $.each(items, function () {
        var ele = $('<div class="order_item fl">\n' +
            '                            <a href="#" class="fl"><img src="' + basePath + this.img_path + '"/></a>\n' +
            '                            <p class="fl">\n' +
            '                                <a href="#">' + this.itemName + '</a>\n' +
            '                                <a href="#">¥' + parseFloat(this.itemPrice).toFixed(2) + '×' + this.itemCount + '</a>\n' +
            '                            </p>\n' +
            '                        </div>')
        //ele.appendTo('.order_items_panel');
        parentNode.children('.shohou').children('.order_items_panel').append(ele);
    })

}

function showEmptyOrderDiv() {
    console.log('No Order');
    var ele = $('<div class="empty_order">\n' +
        '                您还未创建过任何订单 先<a href="' + basePath + '/pages/shopping.jsp' + '">去逛逛</a>吧~\n' +
        '            </div>');
    $('.order_list_title').after(ele);
}

function showOrders(orders) {
    if (orders.length === 0) {
        showEmptyOrderDiv();
        return;
    }
    $.each(orders, function () {
        //console.log(this);
        var ele = $('<div class="dkuang clearfix deng">\n' +
            '                <div class="word clearfix">\n' +
            '                    <ul class="fl clearfix">\n' +
            '                        <li>' + this.createTime + '</li>\n' +
            '                        <li>' + this.receivingName + '</li>\n' +
            '                        <li>订单号:' + this.orderId + '</li>\n' +
            '                    </ul>\n' +
            '                    <p class="fr">订单金额：<span>' + this.orderPrice + '</span>元</p></div>\n' +
            '                <div class="shohou clearfix">\n' +
            '                    <div class="order_items_panel fl">\n' +
            '                    </div>\n' +
            '                    <p class="fr order_action">\n' +
            '                        <a href="' + basePath + '/pages/manager/orderInfo.jsp?orderId=' + this.orderId + '">订单详情</a>' +
            '                    </p>\n' +
            '                </div>\n' +
            '            </div>');
        showOrderItems(this.orderItems, ele);
        parseOrderStatue(this.orderStatue, ele);
        $('.order_list_title').after(ele);
    })
}

function parseOrderStatue(statue, parentNode) {
    var ele = $('<p class="one"></p>');
    var orderAction = $('<a> </a>');
    //var orderActionLi = $('<li></li>');
    var statueStr;
    if (statue === 100) {
        statueStr = '待支付';
        orderAction.append('去付款');
        orderAction.click(function () {
            //alert('success');
        })
    } else if (statue === 200) {
        statueStr = "待发货";
        orderAction.append('确认收货');
    } else if (statue === 300) {
        statueStr = "待签收";
        orderAction.append('确认收货');
    } else if (statue === 400) {
        statueStr = "已签收";
        orderAction.append('确认收货');
    } else if (statue === 500) {
        parentNode.removeClass('deng');
        statueStr = "已关闭";
        orderAction.append('交易关闭');
    } else if (statue === 600) {
        parentNode.removeClass('deng');
        statueStr = "已完成";
        orderAction.append('交易成功');

    }
    ele.append(statueStr);
    parentNode.children('.word').before(ele);
    parentNode.children('.shohou').children('.order_action').append(orderAction);

}

function _statue100() {

}

function parseCreateTime(createTime) {

}


function jsonStringToObj(result) {
    if (typeof result == "string") {
        return eval('(' + result + ')');
    }
}
