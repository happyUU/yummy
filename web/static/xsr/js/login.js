// const url = "http://59.110.143.57:8080/yummy/login";
//const  url="http://localhost:8080/yummy/login"

if (localStorage.getItem("yummyName")) {
  console.log("sure");
  $("#phone").val(localStorage.getItem("yummyName"));
  $("#password").val(localStorage.getItem("yummyPassword"));
  $("#remember").attr("checked", true);
}
$("#login_btn").click(function() {
    var $k = $('input');
    for (let i = 0; i < $k.length; i++) {
        if ($k[i].value === '') {
            alert('请输入完整的信息');
            return;
        }
    }
  var name = $("#username").val(),
    pass = $("#password").val();
  // console.log("bingo");
  console.log($("#remember").val());
  if ($("#remember").val()) {
    // console.log('local');
    // console.log(localStorage.getItem('yummyName'));
    if (localStorage.getItem("yummyName") == null) {
      // console.log('set');
      // console.log(name, pass);
      localStorage.setItem("yummyName", name);
      localStorage.setItem("yummyPassword", pass);
    }
  }
  $.ajax({
    url: "login.action",
    type: "POST",
    data: {
      username: name,
      password: pass
    },
    // data: {
    // keywords: "shuang"
    // },
    error: function(e) {
      console.log("error", e.statusText);
    },
    success: function(res) {
      // console.log('res', res);
      // res { status: , statusText:  }
      var num = res.status;
      if (num === 200) {
        alert("登录成功，即将跳转到主界面")
/*
        location.href = "/yummy/index";
        sessionStorage.setItem("username", name);*/
      } else if (num === 500) {
        var nb = res.msg;
        if (nb == 110) {
          alert("密码错误，请重新填写");
        } else if (nb == 120) {
          alert("用户名错误，请重新填写");
        }
      }
    },
    complete: function(d) {
      console.log("done");
    }
  });
});
