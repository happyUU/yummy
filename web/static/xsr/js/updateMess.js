// const RegisterUrl = "http://59.110.143.57:8080/yummy/registerMessage";



$('#regis_btn').click(function () {
    var count = 0;
    var $k = $('.normal_input'),
        username = $('#username').val(),
        cellPhone = $('#cellphone').val(),
        email = $('#email').val(),
        pass = $('#password').val(),
        paypass=$('#pPassword').val();
    // console.log($k);
    for (let i = 0; i < $k.length; i++) {
        if ($k[i].value === '') {
            flag = true;
            return;
        }
    }
    var reg = /\w+[@]{1}\w+[.]\w+/;
    if ($('#cellphone').val().length !== 11||$('#cellphone').val().length!==0) { //电话不是11位或者不为0
        alert('请输入正确的电话号码');
        return;
    } else if (!!!reg.test($('#email').val())||$('email').val().length!==0) {//邮箱验证错误或长度不为0
        alert('请输入正确的email地址');
        return;
    } else if ($('#password').val() !== $('#sure_pass').val()) {
        alert('请重新确认密码');
        return;
    } else {
        $.ajax({
            url: "update.admin",
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
    }
});
