//获取当前网址，如： http://localhost:8080/yummy/index.jsp
var curPath=window.document.location.href;
//获取主机地址之后的目录，如： yummy/index.jsp
var pathName=window.document.location.pathname;
var pos=curPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8080
var localhostPath=curPath.substring(0,pos);
//获取带"/"的项目名，如：/yummy
var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);

const basePath = localhostPath+projectName;


$(function () {
    listProduct();
    $(document).on('click','.add_cart_btn', function () {
        var productId = $(this).attr('product_id');
        addItemToCart(productId);
    });
    $('#shoppingCar').click(function (e) {
        // var node = e.target;
        location.href = basePath + "/template/cart.jsp";
    });
})


function addItemToCart(productId) {
    $.ajax({
        url: basePath + "/addCartItem.cart",
        type: 'POST',
        data:{
            'product_id':productId
        },
        success: function (result) {
            //console.log(result);
            alert('成功添加商品至购物车');
            //showProduct(result.msgItems.cookerList);
            //showAddSuccessMessage(result.msgItems);
        }
    });
}

function listProduct(){
    $.ajax({
        url: basePath + "/listProductsForPage.cart",
        type: 'POST',
        dataType:'json',
        success: function (result) {
            if(typeof result == "string"){
                result = eval('(' + result + ')');
            }
          showProducts(result.msgItems.cookerPage);
          showProducts(result.msgItems.fruitsPage);
          showProducts(result.msgItems.snacksPage);
        },
        error: function (res) {
            console.log('error', res);
        }
    });
}

function showProducts(result) {
    var items = result.items;
    for(var i = 0; i < items.length; i++){
        createGoodsEle(items[i]);
    }
}
function createGoodsEle(item) {
    var goodsLi = $('<li class="goods"></li>');
    var imgEle = $('<img />');
    var goodsDiv = $('<div class="good_price"></div>');
    var goodsNameDiv = $('<div class="good_name"></div>');
    var goodPriceDiv = $('<div class="price"></div>');
    var addItemBtn = $('<button></button>');

    imgEle.attr("src", basePath + item.img_path);
    goodsNameDiv.append(item.name);
    goodPriceDiv.append('￥' + item.price);
    addItemBtn.attr("product_id", item.productId).text("加入购物车").addClass("add_cart_btn");
    goodsDiv.append(goodsNameDiv).append(goodPriceDiv).append(addItemBtn);
    goodsLi.append(imgEle).append(goodsDiv).appendTo($('#'+ item.type + '_goods'));
}
