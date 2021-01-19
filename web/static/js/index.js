$(document).ready(function () {
    var set = setHeight();
    var data = {};
    var user = postAjax("isLogin.action",data);
    if("error"==user){
        $("#login_link").show();
        $("#register_link").show();
        $("#userId_link").hide();
    }else {
        $("#login_link").hide();
        $("#register_link").hide();
        $("#userId_link").show();
        $("#userId_link").children().text(user[0].name);
    }
});