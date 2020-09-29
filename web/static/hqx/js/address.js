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
        url: basePath + '/getUserAddresses.userAddress',
        type: 'Post',
        success: function (result) {
            result = jsonStringToObj(result);
            showAddress2(result.items);
        }
    })

    $(document).on('click', '.update_btn', function () {
        var addressId = $(this).parent().parent().attr('addressId');

        getAddrById2(addressId);

        $('.addr_id').val(addressId);
        $(".mask").show();
        $(".editAddre").show();
    })

    $(document).on('click', '.add_addr_btn', function () {
        showProvinces(true);
        $('.add_addr form input[type=text]').val('');
        $('.add_addr form textarea').val('');
        $(".mask").show();
        $(".adddz").show();
    })

    $(document).on('change', '.addr_province', function () {
        var provinceId = $(this).val();
        showCities(provinceId, true);
    })
    $(document).on('change', '.addr_city', function () {
        var cityId = $(this).val();
        showCounties(cityId, true);
    })

    $(document).on('click', '.dle_btn', function () {
        if(confirm('确认删除该收货地址？')){
            $.ajax({
                url: basePath + '/deleteAddress.userAddress',
                type: 'POST',
                data: {
                    'addr_id': $(this).parent().parent().attr('addressid')
                },
                //async: false,
                success: function (result) {
                    result = jsonStringToObj(result);
                    showAddress2(result.items);
                }
            })
        }

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
                showAddress2(result.items);
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
                alert('地址更新成功');
                showAddress2(result.items);
                $(".mask").hide();
                $(".adddz").hide();
            }
        })
    })
    $(document).on('click', '.mask_cancel', function () {
        $(".mask").hide();
        $(".adddz").hide();
    })
})

//              <div class="dizhi">
//                     <p>六六六</p>
//                     <p>1573****666</p>
//                     <p>河北省 唐山市 路北区</p>
//                     <p>唐山市大学生公寓村（063000）</p>
//                 </div>
function showAddress2(items) {
    console.log(items);
    $('.dizhi').remove();
    $.each(items, function () {
        $('<div class="dizhi address_item" addressid="' + this.addressId + '">\n' +
            '                    <p>' + this.recName + '</p>\n' +
            '                    <p>' + this.recPhone + '</p>\n' +
            '                    <p>' + this.province.name + ' ' +  this.city.name + ' ' + this.county.name + '</p>\n' +
            '                    <p>' + this.detailAddress + '</p>' +
            '                    <p class="addp"><a class="update_btn">修改</a><a class="dle_btn">删除</a></p>' +
            '                </div>').appendTo('.user_address_list');
    })
   // $(this).append($('<p class="addp"><a href="#"  class="readd">修改</a><a href="#" class="deladd">删除</a></p>'));
}

function jsonStringToObj(result) {
    if (typeof result == "string") {
        return eval('(' + result + ')');
    }
}

function getAddrById2(addressId) {
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

