$(document).ready(function () {
    var set = setHeight();
    $("#login_errorMessage").hide();
    changeBox(getUrlParam("type"));
    $("#login_submit").click(function () {
        var user_id = $("#login_user_id").val();
        var user_password = $("#login_user_password").val();
        var user_data ={
            uId:user_id,
            uPassword:user_password
        };
        var user = postAjax("userLogin.action",user_data);
        if("error"==user){
            $("#login_errorMessage").show();
            $("#login_errorMessage").text("账号或密码错误");
        }else {
            window.location.href="index.html";
        }
    });
    $("#reg_submit").click(function () {
        var user_name = $("#reg_name").val();
        var user_password0 = $("#reg_password0").val();
        var user_password1 = $("#reg_password1").val();
        var user_phone = $("#reg_phone").val();
        var user_address = $("#reg_address").val();
        if(user_password0==user_password1&&null!=user_password1){
            var u_data = {
              uPassword:user_password1,
              uName:user_name,
              uPhone:user_phone,
              uAddress:user_address
            };
            var user = postAjax("register.action",u_data);
            $("#ret_id").text(user[0].id);
            changeBox("id")
        }else {
            $("#reg_password1").text("请确认密码");
        }
    });
})
function changeBox(type) {
    if ("login"==type){
        $(".login_box").show();
        $(".reg_box").hide();
        $(".ret_userId").hide();
    }else if("register"==type){
        $(".login_box").hide();
        $(".reg_box").show();
        $(".ret_userId").hide();
    }else{
        $(".login_box").hide();
        $(".reg_box").hide();
        $(".ret_userId").show();
    }
}
