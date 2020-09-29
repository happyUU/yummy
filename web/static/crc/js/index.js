var good = document.querySelectorAll('.fa-thumbs-up');
var heart = document.querySelectorAll('.fa-heart');
// console.log(good[0].parentNode.childNodes[1]);
function addGood(e) {
    var node = event.target;
    // console.log(node.parentNode.childNodes[3]);
    // console.log(good.style);
    // var color = good.getAttrbute('color');
    var num = node.parentNode.childNodes[3].innerHTML;
    // console.log(num);
    if (!node.classList.contains('choosed')) {
        node.classList.add('choosed');
        node.parentNode.childNodes[3].innerHTML = parseInt(num) + 1;
    } else {
        node.classList.remove('choosed');
        node.parentNode.childNodes[3].innerHTML = parseInt(num) - 1;
    }
}

good[0].onclick = addGood;
heart[0].onclick = addGood;