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
    $.ajax({
        url: basePath + '/getCartItems.order',
        type: 'POST',
        success: function (result) {
            result = jsonStringToObj(result);
            showCartItems(result.msgItems.cartItems);
        }
    })

    //显示当前登陆用户的收件信息
    $.ajax({
        url: basePath + '/getUserAddresses.userAddress',
        type: 'Post',
        success: function (result) {
            result = jsonStringToObj(result);
            showAddress(result.items);
        }
    })

    $(document).on('click', '.edit', function () {
        var addressId = $(this).attr('addressId');

        getAddrById(addressId);

        $('.addr_id').val(addressId);
        $(".mask").show();
        $(".editAddre").show();
    })
    $(document).on('click', '.del_address_btn', function () {
        if(confirm('删除该收货地址？')){
            $.ajax({
                url: basePath + '/deleteAddress.userAddress',
                type: 'POST',
                data: {
                    'addr_id': $(this).attr('addressid')
                },
                //async: false,
                success: function (result) {
                    result = jsonStringToObj(result);
                    showAddress(result.items);
                }
            })
        }
    })
    $(document).on('click', '.add_addr_btn', function () {
        showProvinces(true);
        $('.add_addr form input[type=text]').val('');
        $('.add_addr form textarea').val('');
        $(".mask").show();
        $(".add_addr").show();
    })

    $(document).on('change', '.addr_province', function () {
        var provinceId = $(this).val();
        showCities(provinceId, true);
    })
    $(document).on('change', '.addr_city', function () {
        var cityId = $(this).val();
        showCounties(cityId, true);
    })

    $(document).on('click', '#mask_save_btn', function () {
        $.ajax({
            url: basePath + '/saveAddress.userAddress',
            data: $('.add_addr form').serialize(),
            //async: false,
            success: function (result) {
                result = jsonStringToObj(result);
                console.log(result);
                alert('收货地址添加成功');
                showAddress(result.items);
                $(".mask").hide();
                $(".adddz").hide();
            }
        })
    })
    $(document).on('click', '#mask_update_btn', function () {
        $.ajax({
            url: basePath + '/updateAddress.userAddress',
            data:
                $('.editAddre form').serialize(),
            //async: false,
            success: function (result) {
                result = jsonStringToObj(result);
                console.log(result);
                alert('收货地址已更新');
                showAddress(result.items);
                $(".mask").hide();
                $(".adddz").hide();
            }
        })
    })
    $(document).on('click', '.mask_cancel', function () {
        $(".mask").hide();
        $(".adddz").hide();
    })

    $(document).on('click', '.pay_btn', function () {
        if ($('.address_panel .on').length === 0) {
            confirm('请选择一个收货地址');
            return;
        }
        var addressId = $('.address_panel .on').attr('addressid');

        $.ajax({
            url: basePath + '/createOrder.order',
            data:{
                'address_id': addressId
            },
            success: function (result) {
                result = jsonStringToObj(result);
                console.log(result);

                location.href = basePath + '/template/pay.jsp';
            }
        })
    })
})

function getAddrById(addressId) {
    $.ajax({
        url: basePath + '/getUserAddress.userAddress',
        data: {
            'addressId': addressId
        },
        type: 'POST',
        success: function (result) {
            result = jsonStringToObj(result);
            console.log(result);
            $('.addr_name').val(result.recName);
            $('.addr_phone').val(result.recPhone);
            showProvinces(false);
            $('.addr_province').val(result.province.id);
            showCities(result.province.id, false);
            $('.addr_city').val(result.city.id);
            showCounties(result.city.id);
            $('.addr_county').val(result.county.id);
            $('.addr_detail').val(result.detailAddress);

        }
    })
}

function showCounties(cityId) {
    var ele = $('.addr_county');
    ele.empty();
    $.ajax({
        url: basePath + '/getCounties.userAddress',
        type: 'POST',
        data: {
            'cityId': cityId
        },
        async: false,
        success: function (result) {
            result = jsonStringToObj(result);
            $.each(result, function (key, value) {
                $('<option></option>').append(value.name).attr('value', key).appendTo(ele);
            })
        }
    })
}

function showCities(provinceId, flag) {
    var ele = $('.addr_city');
    ele.empty();
    $.ajax({
        url: basePath + '/getCities.userAddress',
        type: 'POST',
        data: {
            'provinceId': provinceId
        },
        async: false,
        success: function (result) {
            result = jsonStringToObj(result);
            $.each(result, function (key, value) {
                $('<option></option>').append(value.name).attr('value', key).appendTo(ele);
            })
            if (flag) {
                showCounties($('.addr_city').val(), flag);
            }
        }
    })
}

function showProvinces(flag) {
    var ele = $('.addr_province');
    ele.empty();
    $.ajax({
        url: basePath + '/getProvinces.userAddress',
        type: 'POST',
        async: false,
        success: function (result) {
            result = jsonStringToObj(result);
            $.each(result, function (key, value) {
                $('<option></option>').append(value.name).attr('value', key).appendTo(ele);
            })
            if (flag) {
                showCities($('.addr_province').val(), flag);
            }
        }
    })
}

function showAddress(items) {
    $('.address_panel').empty();
    $.each(items, function () {
        var ele = $('<div class="addre fl" addressid="' + this.addressId + '">\n' +
            '                    <div class="tit clearfix"><p class="fl">' + this.recName + '</p>\n' +
            '                        <p class="fr">\n' +
            '                            <span>|</span><button type="button" class="btn btn-link del_address_btn" addressid="' + this.addressId + '">删除</button>\n' +
            '                            <span>|</span><button type="button" class="btn btn-link edit" addressid="' + this.addressId + '">编辑</button>\n' +
            '                        </p>\n' +
            '                    </div>\n' +
            '                    <div class="addCon"><p>' + this.province.name + ' ' + this.city.name + ' ' +
            this.county.name + ' ' + this.detailAddress + '</p>\n' +
            '                        <p>' + this.recPhone + '</p></div>\n' +
            '                </div>')
        ele.appendTo($('.address_panel'));
    })
}

function showCartItems(items) {
    var totalPrice = 0;
    var discountPrice = 0;
    var payTotalPrice = 0;
    $.each(items, function (key, value) {
        var ele = $('<ul class="clearfix">\n' +
            '                            <li class="fl"><img src="' + basePath + value.img_path + '"></li>\n' +
            '                            <li class="fl">\n' +
            '                                <p>' + value.name + '</p>\n' +
            '                                <p>' + value.type + '</p>\n' +
            '                                <p>数量：' + value.count + '</p></li>\n' +
            '                            <li class="fr">￥' + parseFloat(value.totalPrice).toFixed(2) + '</li>\n' +
            '                        </ul>');
        ele.appendTo($('.order .orderCon .orderR .panel .panel-body'));
        totalPrice += parseFloat(value.totalPrice);
    })
    payTotalPrice = totalPrice - discountPrice;
    $('#total_price').text('￥' + parseFloat(totalPrice).toFixed(2));
    $('#discount_price').text('￥' + parseFloat(discountPrice).toFixed(2));
    $('#pay_total_price').text('￥' + parseFloat(payTotalPrice).toFixed(2));
}

function jsonStringToObj(result) {
    if (typeof result == "string") {
        return eval('(' + result + ')');
    }
}