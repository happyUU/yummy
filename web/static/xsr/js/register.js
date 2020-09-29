// const RegisterUrl = "http://59.110.143.57:8080/yummy/registerMessage";
const RegisterUrl = "http://localhost:8080/yummy/registerMessage";


$('#regis_btn').click(function () {
    var $k = $('.normal_input'),
        username = $('#username').val(),
        cellPhone = $('#cellphone').val(),
        email = $('#email').val(),
        pass = $('#password').val();
    // console.log($k);
    for (let i = 0; i < $k.length; i++) {
        if ($k[i].value === '') {
            alert('请输入完整的信息');
            return;
        }
    }
    var reg = /\w+[@]{1}\w+[.]\w+/;
    if ($('#cellphone').val().length !== 11) {
        alert('请输入正确的电话号码');
        return;
    } else if (!!!reg.test($('#email').val())) {
        alert('请输入正确的email地址');
        return;
    } else if ($('#password').val() !== $('#sure_pass').val()) {
        alert('请重新确认密码');
        return;
    }/* else {
        $.ajax({
            url: "register.action",
            type: 'POST',
            data: {
                username: username,
                cellPhone: cellPhone,
                email: email,
                password: pass
            },
            success: function (res) {
                var num = res.status;
                if(num === 200){
                    alert("注册成功，即将返回登录页面");
                    //location.href="/yummy/login";
                }else{
                     alert("用户名已存在，请重新输入");
                }
            },
        });
    }*/
});
