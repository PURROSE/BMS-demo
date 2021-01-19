function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
};
function postAjax(url,data) {
    var returnData;
    $.ajax({
        url:url,
        data:data,
        type:'post',
        dataType:'json',
        async:false,
        success:function (data) {
            returnData = JSON.parse(data);
        },
        error:function () {

        }
    });
    return returnData;
}
function isLogin(user) {
    if("error"==user){
        $("#login_link").show();
        $("#register_link").show();
        $("#userId_link").hide();
        window.location.href="login.html?type=login";
    }else {
        $("#login_link").hide();
        $("#register_link").hide();
        $("#userId_link").show();
        $("#userId_link").text(user[0].name);
        return true;
    }
}
function setHeight() {
    var height = $(window).height();
    $("body").css("height",height);
}
function changeTime(t) {
    var time = t.trim().split(" ");
    var month = time[0];
    var wek = ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    //月份处理
    for(i=0;i<12;i++){
        if (month==wek[i]){
            if (i>9){
                time[0]=""+i;
            }else {
                time[0]="0"+i;
            }
        }
    }
    //天数处理{
    if (time[1].length>2){
        time[1] = time[1].substring(0,2);
    }else
    {
        time[1] ="0"+ time[1].substring(0,1);
    }
    //小时处理
    var houth = time[3].split(":");
    if (time[4]=="PM"){
        houth[0] = parseInt(houth[0])+12;
        time[3]=houth[0]+":"+houth[1]+":"+houth[2];
    }else if (parseInt(houth[0])<10){
        houth[0]="0"+houth[0];
    }
    return time[2]+"-"+time[0]+"-"+time[1]+" "+time[3];
}
function pagSet(f,ul,y) {
    ul.html("");
    var p="";
    var yem = f/10+1;
    for (i=1;i<=yem;i++){
        if (i==y){
            p+="<li class='active'><a>"+i+"</a>"
        }else {
            p+="<li><a>"+i+"</a>"
        }
    }
    p="<li><a>&laquo;</a>"+p+"<li><a>&raquo;</a>";
    ul.html(p);
}