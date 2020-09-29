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

window.onbeforeunload = function(event) {
    var cartMap = new Map();
    var ids = "";
    $.each($('.cart_item_checkbox:checked'), function () {
        ids = ids + '-' + $(this).attr('itemid');
    })
    cartMap.set('checked', ids);
    ids = "";
    $.each($('.cart_item_checkbox'), function () {
        ids = ids + '-' + $(this).attr('itemid');
    })
    cartMap.set('items', ids);
    var counts = "";
    $.each($('.cart_item_count'), function () {
        counts = counts + '-' + $(this).text();
    })
    cartMap.set('counts', counts);
    refreshCart(cartMap);
}

function refreshCart(map){
    var obj = Object.create(null);
    for(var[k,v] of map){
        console.log(k);
        console.log(v);
        obj[k] = v;
    }
    $.ajax({
        url: basePath + '/refreshCart.cart',
        data: {
            'map': JSON.stringify(obj)
        }
    })

}

function refreshCheckedBox(){
    var flag = $('.cart_item_checkbox:checked').length === $('.cart_item_checkbox').length;
    $('#check_all_checkbox').prop('checked', flag);
}

function refreshTotal(){
    var checkedItems = $('.cart_item_checkbox:checked');
    // console.log(checkedItems);
    var totalPrice = 0;
    var totalCount = 0;
    if (checkedItems.length > 0) {
        $('#count_cart_btn').removeAttr('disabled');
        $.each(checkedItems, function (index, item) {
            //console.log(totalPrice);
            var parentNode = $(item).parent().parent().parent();
            totalCount += parseInt($(parentNode.children('.number').children('.num').children('span')[0]).text());
            totalPrice = totalPrice + parseFloat($(parentNode.children('.price_total')[0]).text().substring(1));
        })
        $('#cart_total_count').text(totalCount);
        $('#cart_total_price').text('￥' + totalPrice.toFixed(2));
    } else {
        $('#count_cart_btn').attr('disabled', 'disabled');
        $('#cart_total_count').text(0);
        $('#cart_total_price').text('￥0.00');
        $('#check_all_checkbox').prop('checked', false);
    }
}

$(function () {
    //showEmptyCartDiv();
    $.ajax({
        url: basePath + '/showCart.cart',
        type: 'POST',
        datatype: 'json',
        success: function (result) {
            if (typeof result == "string") {
                result = eval('(' + result + ')');
            }
            showCart(result);
            showChecked(result.msgItems.cart.checkedCartItems);
        }
    });

    $(document).on('click', '.cart_item_del_btn', function () {
        if(confirm("确认移除该商品？")){
            $(this).parent().parent().remove();
            refreshCheckedBox();
            refreshTotal();
            if($('.cart_item_td').length === 0){
                showEmptyCartDiv();
            }
        }

        // $.ajax({
        //     url: basePath + '/deleteCartItem.cart',
        //     type: 'POST',
        //     data: {
        //         'itemIds': $(this).attr('itemId')
        //     },
        //     success: function (result) {
        //         if (typeof result == "string") {
        //             result = eval('(' + result + ')');
        //         }
        //         showCart(result);
        //     }
        // })
    })

    $(document).on('click', '.delete_checked_btn', function () {
        if(confirm("确认移除选中商品？")){
            $.each($('.cart_item_checkbox:checked'), function () {
                $(this).parent().parent().parent().remove();
                refreshCheckedBox();
                refreshTotal();
                if($('.cart_item_td').length === 0){
                    showEmptyCartDiv();
                }
            })
        }
        // var ids = "";
        // $.each($('.cart_item_checkbox:checked'), function () {
        //     ids = ids + "-" + $(this).attr('itemId');
        // })
        // $.ajax({
        //     url: basePath + '/deleteCartItem.cart',
        //     type: 'POST',
        //     data: {
        //         'itemIds' : ids.substring(1)
        //     },
        //     success: function (result) {
        //         if (typeof result == "string") {
        //             result = eval('(' + result + ')');
        //         }
        //         showCart(result);
        //     }
        // })
    })

    $(document).on('change', '.cart_item_checkbox', function () {
        refreshCheckedBox();
        refreshTotal();
    })

    $(document).on('change', '#check_all_checkbox', function () {
        $('.cart_item_checkbox').prop('checked', $(this).prop('checked'));
        refreshTotal();
    })

    $(document).on('click', '#check_all_btn', function () {
        var flag = $("#check_all_checkbox").prop('checked');
        $('#check_all_checkbox').prop('checked', !flag);
        $('.cart_item_checkbox').prop('checked', !flag);
        refreshTotal();
    })

    $(document).on('click', '#count_cart_btn', function () {
        // var ids = "";
        // $.each($('.cart_item_checkbox:checked'), function () {
        //     ids = ids + "-" + $(this).attr('itemId');
        // })
        // ids = ids.substring(1);
        //
        location.href = basePath + "/template/order.jsp";
    })

    $(document).on('click', '.num .sub', function () {
        var count = parseInt($(this).siblings("span").text());
        if (count <= 1) {
        } else {
            count--;
            $(this).siblings("span").text(count);
            countChanged($(this).siblings("span"));
        }
    });

    $(document).on('click', '.num .add', function () {
        var c = parseInt($(this).siblings("span").text());
        c++;
        $(this).siblings("span").text(c);
        countChanged($(this).siblings("span"));
    });
});

function countChanged(ele) {
    var count = ele.text();
    var parentNode = ele.parent().parent().parent();
    var price = $(parentNode.children('.price_single')[0]).text();
    price = parseFloat(price.substring(1));

    $(parentNode.children('.price_total')[0]).text('￥' + (price * count).toFixed(2));

    if (parentNode.children('.pro').children('.fl').children('.cart_item_checkbox').prop('checked')) {
        console.log('checked true');
        refreshTotal();
    }
}

//                      <div class="td">
//                         <div class="pro clearfix">
//                             <label class="fl"><input type="checkbox"/><span></span></label>
//                             <a class="fl" href="#"><dl class="clearfix">
//                                 <dt class="fl" ><img class="cart_item_img" src="${pageContext.request.contextPath}${cartItem.value.img_path}"></dt>
//                                 <dd class="fl">
//                                     <p>${cartItem.value.name}</p>
//                                     <p>颜色分类:</p>
//                                     <p>${cartItem.value.name}</p>
//                                 </dd>
//                             </dl></a>
//                         </div>
//                         <div class="price">￥${cartItem.value.price}</div>
//                         <div class="number">
//                             <p class="num clearfix">
//                                 <img class="fl sub" src="${pageContext.request.contextPath}/static/img/temp/sub.jpg">
//                                 <span class="fl cart_item_count" itemid="${cartItem.value.id}">${cartItem.value.count}</span>
//                                 <img class="fl add" src="${pageContext.request.contextPath}/static/img/temp/add.jpg">
//                             </p>
//                         </div>
//                         <div class="price sAll">￥${cartItem.value.totalPrice}</div>
//                         <div class="price"><button type="button" class="btn btn-link cart_item_del_btn" itemid="${cartItem.value.id}">删除</button></div>
//                     </div>

function showCart(result) {
    $('.cart_item_td').remove();
    if (true === result.msgItems.cart.emptyCart) {
        showEmptyCartDiv();
    } else {
        removeElement($('#empty_cart_div'));
        $.each(result.msgItems.cart.cartItems, function (key, value) {
            showCartItem(value);
        });
    }
    refreshTotal();
}

function showChecked(result) {
    $.each(result, function (key, value) {
        $('.cart_item_checkbox[itemid=' + key + ']').attr('checked', true);
    })
    refreshCheckedBox();
    refreshTotal();
}

function showCartItem(item) {
    var ele = $('<div class="td cart_item_td">\n' +
        '                        <div class="pro clearfix">\n' +
        '                            <label class="fl"><input type="checkbox" itemid="' + item.id + '" class="cart_item_checkbox"/><span></span></label>\n' +
        '                            <a class="fl" href="#"><dl class="clearfix">\n' +
        '                                <dt class="fl" ><img class="cart_item_img" src="' + basePath + item.img_path + '"></dt>\n' +
        '                                <dd class="fl">\n' +
        '                                    <p>' + item.name + '</p>\n' +
        '                                    <p>颜色分类:</p>\n' +
        '                                    <p>' + item.name + '</p>\n' +
        '                                </dd>\n' +
        '                            </dl></a>\n' +
        '                        </div>\n' +
        '                        <div class="price price_single">￥' + parseFloat(item.price).toFixed(2) + '</div>\n' +
        '                        <div class="number">\n' +
        '                            <p class="num clearfix">\n' +
        '                                <img class="fl sub" src="' + basePath + '/static/hqx/img/temp/sub.jpg">\n' +
        '                                <span class="fl cart_item_count" itemid=' + item.id + '>' + item.count + '</span>\n' +
        '                                <img class="fl add" src="' + basePath + '/static/hqx/img/temp/add.jpg">\n' +
        '                            </p>\n' +
        '                        </div>\n' +
        '                        <div class="price price_total sAll">￥' + parseFloat(item.totalPrice).toFixed(2) + '</div>\n' +
        '                        <div class="price"><button type="button" class="btn btn-link cart_item_del_btn" itemid="' + item.id + '">删除</button></div>\n' +
        '                    </div>');
    $('#cart_table #cart_table_head').after(ele);
}

function showEmptyCartDiv() {
    var ele = $('<div class="goOn" id="empty_cart_div">空空如也~<a href="' + basePath + '/template/shopping.jsp">去逛逛</a></div>');
    $('#cart_table #cart_table_head').after(ele);
}

function removeElement(element) {
    $(element).remove();
}

// const cart_info = [
//     //     {
//     //     name: "antd",
//     //     price: 123,
//     //     num: 33,
//     //     id: 1,
//     // }, {
//     //     name: "ice",
//     //     price: 32,
//     //     num: 890,
//     //     id: 2,
//     // }
// ];
//
// // if (sessionStorage.getItem('shopNum')) {
// //     console.log('in');
// //     var shopcar = sessionStorage.getItem('shopNum');
// //     var arr1 = shopcar.split(',');
// //     objLength(arr1);
//
// // } else {
// console.log('come in');
// $.ajax({
//     url: cartUrl,
//     type: 'POST',
//     data: {
//         username: sessionStorage.getItem('username'),
//     },
//     error: function (res) {
//         console.log('error', res);
//     },
//     success: function (res) {
//         let arr = res.toString();//返回的字符串的名字
//         let resArr = arr.split(',');
//         objLength(resArr);
//         toStep(1);
//     }
// })
// // }
//
// //对象
// function objLength(arr) {
//     for (let i = 0; i < arr.length; i++) {
//         let m = arr[i];
//         let obj = {
//             name: `${goodName(m)}`,
//             price: priceArr[m - 1],
//             num: 1,
//             id: m,
//         }
//         // console.log(m, obj);
//         cart_info.push(obj);
//     }
//     // console.log(cart_info);
// }
//
// //判断商品名称
// function goodName(num) {
//     if (num <= 8) {
//         return '厨具';
//     } else if (num <= 12) {
//         return '水果';
//     } else if (num <= 16) {
//         return '低脂';
//     } else {
//         return '美味';
//     }
// }
//
// // 全局状态
// const state = {
//     step: 1,
//     selected: cart_info,
//     cast: 0,
// }
//
// $(document).ready(function name(params) {
//
//     // 初始状态
//     toStep(1);
//
//     // 事件委托
//     $("#event-wrap").click(function (e) {
//         const target = e.target;
//         id = target.id,
//             className = target.className;
//         // console.log("className", className,"id",id)
//         if (id === "btn-order") {
//             setStep(2);
//         } else if (id === "btn-pay") {
//             setStep(3);
//         } else if (className == "cancel-pro") {
//             if (confirm("是否永久删除？")) {
//                 updateSelect_remove(target.dataset.id);
//                 $.ajax({
//                     url: deleteProductUrl,
//                     type: 'POST',
//                     data: {
//                         username: sessionStorage.getItem('username'),
//                         id: target.dataset.id,
//                     },
//                     error: function (res) {
//                         console.log('error', res);
//                     },
//                     success: function(res) {
//                         alert('已成功删除该商品');
//                     }
//                 })
//             }
//         }
//     })
// })
//
// function setStep(step) {
//     state.step = step;
//     toStep(step);
// }
//
// function updateSelect_remove(id) {
//     const step = state.step;
//     state.selected = state.selected.filter(item => {
//         return item.id != id
//     })
//     toStep(step);
//
// }
//
// function toStep(step) {
//     // 清空
//     $("#cart-content")[0].innerHTML = "";
//     // 更新步骤条
//     const children = $("#order-head").children();
//     children.each(item => {
//         $(children[item]).removeClass("selected");
//     })
//     $(`#order-head div:nth-child(${step})`).addClass("selected");
//     switch (step) {
//         case 1: {
//             render_cart(state.selected);
//             break;
//         }
//         case 2: {
//             // 计算总价
//             let sum = 0;
//             state.selected.forEach(item => {
//                 sum += item.price;
//             })
//             state.cast = sum;
//             render_cart(state.selected, "order");
//             break;
//         }
//         case 3: {
//             // 渲染表单
//             $("#cart").hide();
//             $("#address_input").show()
//             break;
//         }
//         default:
//     }
// }
// // 更新步骤调
//
//
// function render_cart(data, type) {
//     var fragment = document.createDocumentFragment();
//     if (Object.prototype.toString.call(data) != "[object Array]") {
//         console.log("ErrorType");
//         return;
//     }
//     data.forEach(item => {
//         var _node = document.createElement('div');
//         _node.innerHTML = `
//         <div class="_col">
//         <div class="_row">${item.name}</div>
//         <div class="_row">￥${item.price}</div>
//         <div class="_row">
//         <input type="number" value=${item.num} min=0 step=1 />
//         </div>
//         <div class="_row"><span data-id=${item.id} class="cancel-pro">取消商品</span></div>
//         </div>`;
//         // console.log(_node);
//         fragment.appendChild(_node);
//     })
//     if (type == "order") {
//         var _node = document.createElement('div');
//         _node.innerHTML = `<div><span>合计：${state.cast}</span></div>
//         <div><button id="btn-pay">立即付款</button></div>`
//         fragment.appendChild(_node);
//     } else {
//         var _node = document.createElement('div');
//         _node.innerHTML = `
//         <div><button id="btn-order">确认订单</button></div>`
//         fragment.appendChild(_node);
//     }
//     // console.log(fragment);
//     $("#cart-content").append(fragment);
// }