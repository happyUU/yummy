// const cartUrl = "http://59.110.143.57:8080/shoppingMessage/userShopping";
const  cartUrl="http://localhost:8080/shoppingMessage/userShopping";
// const cartUrl = "http://59.110.143.57:8080/shoppingMessage/deleteProduct";
const deleteProductUrl="http://localhost:8080/shoppingMessage/deleteProduct"
//商品价格
const priceArr = [599, 399, 109, 288, 358, 159, 59, 79, 10, 100, 30, 18, 100, 300, 150, 180, 108, 50, 200, 180];
// console.log(priceArr.length);
const cart_info = [
    //     {
    //     name: "antd",
    //     price: 123,
    //     num: 33,
    //     id: 1,
    // }, {
    //     name: "ice",
    //     price: 32,
    //     num: 890,
    //     id: 2,
    // }
];

// if (sessionStorage.getItem('shopNum')) {
//     console.log('in');
//     var shopcar = sessionStorage.getItem('shopNum');
//     var arr1 = shopcar.split(',');
//     objLength(arr1);

// } else {
console.log('come in');
$.ajax({
    url: cartUrl,
    type: 'POST',
    data: {
        username: sessionStorage.getItem('username'),
    },
    error: function (res) {
        console.log('error', res);
    },
    success: function (res) {
        let arr = res.toString();//返回的字符串的名字
        let resArr = arr.split(',');
        objLength(resArr);
        toStep(1);
    }
})
// }

//对象
function objLength(arr) {
    for (let i = 0; i < arr.length; i++) {
        let m = arr[i];
        let obj = {
            name: `${goodName(m)}`,
            price: priceArr[m - 1],
            num: 1,
            id: m,
        }
        // console.log(m, obj);
        cart_info.push(obj);
    }
    // console.log(cart_info);
}

//判断商品名称
function goodName(num) {
    if (num <= 8) {
        return '厨具';
    } else if (num <= 12) {
        return '水果';
    } else if (num <= 16) {
        return '低脂';
    } else {
        return '美味';
    }
}

// 全局状态
const state = {
    step: 1,
    selected: cart_info,
    cast: 0,
}

$(document).ready(function name(params) {

    // 初始状态
    toStep(1);

    // 事件委托
    $("#event-wrap").click(function (e) {
        const target = e.target;
        id = target.id,
            className = target.className;
        // console.log("className", className,"id",id)
        if (id === "btn-order") {
            setStep(2);
        } else if (id === "btn-pay") {
            setStep(3);
        } else if (className == "cancel-pro") {
            if (confirm("是否永久删除？")) {
                updateSelect_remove(target.dataset.id);
                $.ajax({
                    url: deleteProductUrl,
                    type: 'POST',
                    data: {
                        username: sessionStorage.getItem('username'),
                        id: target.dataset.id,
                    },
                    error: function (res) {
                        console.log('error', res);
                    },
                    success: function(res) {
                        alert('已成功删除该商品');
                    }
                })
            }
        }
    })
})

function setStep(step) {
    state.step = step;
    toStep(step);
}

function updateSelect_remove(id) {
    const step = state.step;
    state.selected = state.selected.filter(item => {
        return item.id != id
    })
    toStep(step);

}

function toStep(step) {
    // 清空
    $("#cart-content")[0].innerHTML = "";
    // 更新步骤条
    const children = $("#order-head").children();
    children.each(item => {
        $(children[item]).removeClass("selected");
    })
    $(`#order-head div:nth-child(${step})`).addClass("selected");
    switch (step) {
        case 1: {
            render_cart(state.selected);
            break;
        }
        case 2: {
            // 计算总价
            let sum = 0;
            state.selected.forEach(item => {
                sum += item.price;
            })
            state.cast = sum;
            render_cart(state.selected, "order");
            break;
        }
        case 3: {
            // 渲染表单
            $("#cart").hide();
            $("#address_input").show()
            break;
        }
        default:
    }
}
// 更新步骤调


function render_cart(data, type) {
    var fragment = document.createDocumentFragment();
    if (Object.prototype.toString.call(data) != "[object Array]") {
        console.log("ErrorType");
        return;
    }
    data.forEach(item => {
        var _node = document.createElement('div');
        _node.innerHTML = ` 
        <div class="_col">
        <div class="_row">${item.name}</div>
        <div class="_row">￥${item.price}</div>
        <div class="_row">
        <input type="number" value=${item.num} min=0 step=1 />
        </div>
        <div class="_row"><span data-id=${item.id} class="cancel-pro">取消商品</span></div>
        </div>`;
        // console.log(_node);
        fragment.appendChild(_node);
    })
    if (type == "order") {
        var _node = document.createElement('div');
        _node.innerHTML = `<div><span>合计：${state.cast}</span></div>
        <div><button id="btn-pay">立即付款</button></div>`
        fragment.appendChild(_node);
    } else {
        var _node = document.createElement('div');
        _node.innerHTML = `
        <div><button id="btn-order">确认订单</button></div>`
        fragment.appendChild(_node);
    }
    // console.log(fragment);
    $("#cart-content").append(fragment);
}