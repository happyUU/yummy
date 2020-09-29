// const SavcProducttUrl = "http://59.110.143.57:8080/shoppingMessage/saveProduct";
const  SaveProductUrl="http://localhost:8080/shoppingMessage/saveProduct"

var shopcar = [];

$('button').click(function (e) {
    var node = e.target;
    var number = node.dataset.num;
    console.log(number);
    shopcar.push(number);
    $(node).attr('disabled', true);
    $(node).addClass('used');
    var name = sessionStorage.getItem('username');
    $.ajax({
        url: SaveProductUrl,
        type: 'POST',
        data: {
            username: name,
            number: number,
        },
        success: function () {
            // location.href = "./car.html"
            alert("成功添加该商品，数量为1");
        },
        error: function (res) {
            console.log('error', res);
        },
    });
});

$('#shoppingCar').click(function (e) {
    // var node = e.target;
    // console.log(shopcar);
    location.href = '/yummy/car';
    sessionStorage.setItem('shopNum', shopcar);
})